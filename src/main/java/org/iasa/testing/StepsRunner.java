package org.iasa.testing;

import static java.util.Arrays.asList;

import java.util.stream.Collectors;

import org.iasa.testing.StepsRunner.MyReportBuilder;
import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.pages.MyProfile;
import org.iasa.testing.steps.GameSteps;
import org.iasa.testing.steps.MyProfileSteps;
import org.iasa.testing.steps.RegisterSteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(AnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@Configure(storyReporterBuilder = MyReportBuilder.class, storyLoader = WebappStoryLoader.class)
@UsingSteps(instances = { RegisterSteps.class, GameSteps.class, MyProfileSteps.class })
public class StepsRunner implements Embeddable {
	private static Logger LOG = LoggerFactory.getLogger(StepsRunner.class);
	
	private Embedder embedder;

	public void useEmbedder(Embedder embedder) {
		this.embedder = embedder;
	}

	@Test
    public void run() {
    	try{    		
    		final String relativeFolder = JBehaveWrapper.getCurrentWorkingFolder().get();
    		embedder.runStoriesAsPaths(new StoryFinder().findPaths(relativeFolder, asList("*.story"), asList("")).stream().map(str -> relativeFolder + str).collect(Collectors.toList()));
    	} catch(Exception e){
    		LOG.error("Failed to run stories", e);
    	} finally{
    		AbstractPage.quit();
		}
    }

	public static class MyReportBuilder extends StoryReporterBuilder {
		public MyReportBuilder() {
			this.withFormats(org.jbehave.core.reporters.Format.CONSOLE, org.jbehave.core.reporters.Format.HTML,
					org.jbehave.core.reporters.Format.STATS);
		}
	}
}
