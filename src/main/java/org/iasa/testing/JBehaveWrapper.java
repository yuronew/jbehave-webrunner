package org.iasa.testing;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.iasa.AppDirectory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryRunner;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.model.Scenario;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JBehaveWrapper {
	private static final String RUNNING_STORY = "running.story";
	private static Logger LOG = LoggerFactory.getLogger(JBehaveWrapper.class);
	private static AppDirectory CURRENT_DIRECTORY;
	
	private static void run() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(StepsRunner.class);
		result.getFailures();
	}

	public static List<Scenario> getDefaultScenarios() {
		return getScenarios(AppDirectory.STORY_ALL_FOLDER.get());
	}
	
	public static List<Scenario> getScenarios(String relativeFolder) {
		final Configuration conf = new MostUsefulConfiguration();
		final StoryRunner runner = new StoryRunner();
		try {
			List<String> paths = new StoryFinder().findPaths(relativeFolder, asList("*.story"), asList(""));
			String full = new File("").getAbsolutePath() + "/" + relativeFolder;
			conf.useStoryLoader(new LoadFromRelativeFile(new URL("file://" + full)));
			return paths.stream().map(p -> runner.storyOfPath(conf, p)).flatMap(s -> s.getScenarios().stream())
					.collect(Collectors.toList());
		} catch (MalformedURLException e) {
			return new ArrayList<>();
		}
	}
	
	public static void writeRunningScenarios(List<Scenario> scenarios) {
		LOG.info("Writing running scenarios: " + scenarios.stream().map(sc -> sc.getTitle()).collect(Collectors.toList()));
		String path = new File("").getAbsolutePath() + "/" + AppDirectory.STORY_RUN_FOLDER.get() + RUNNING_STORY;
		try (final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"))) {
			for (Scenario sc : scenarios){
				writer.write(writeToString(sc));
			}
		} catch (IOException e) {
			LOG.error("Failed to write running scenarios", e);
		}
	}
	
	private static String writeToString(Scenario sc){
		final StringBuilder builder = new StringBuilder();
		sc.getSteps().stream().forEach(st -> builder.append(st + "\n"));
		return "Scenario: " + sc.getTitle() + "\n" + builder + "\n";
	}

	public static boolean testScenarios() {
		CURRENT_DIRECTORY = AppDirectory.STORY_TEST_FOLDER;
		run();
		
		try(BufferedReader reader = new BufferedReader(new FileReader("target/jbehave/src.main.resources.new.out.html"))){
			return !reader.lines().filter(str -> str.contains("pre class=\"pending\"")).findAny().isPresent();
		} catch (IOException e) {
			LOG.error("Error openeing test file", e);
		}
		return false;
	}

	public static void runScenarios() {
		CURRENT_DIRECTORY = AppDirectory.STORY_RUN_FOLDER;
		run();
	}
	
	public static AppDirectory getCurrentWorkingFolder(){
		return CURRENT_DIRECTORY;
	}

}
