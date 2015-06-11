package org.iasa.testing;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.jbehave.core.model.Scenario;

public class SearchEngine {
	private static final String TRIMMER = " ";

	public static List<Scenario> getScenariosByTags(String tagsString) {
		if (tagsString.isEmpty()){
			return JBehaveWrapper.getDefaultScenarios();
		}
		
		List<String> tags = getTagsFromStr(tagsString);
		List<Scenario> allScenarios = JBehaveWrapper.getDefaultScenarios();
		List<Scenario> found = allScenarios
				.stream()
				.filter(sc -> tags.stream()
						.filter(t -> sc.getTitle().contains(t)).findAny()
						.isPresent()).collect(toList());

		return found;
	}
	
	public static List<Scenario> getMinScenariosByTags(String tagsString) {
		List<Scenario> found = new ArrayList<>();
		List<Scenario> searchSet;

		if (tagsString.isEmpty()){
			searchSet =  JBehaveWrapper.getDefaultScenarios();
		} else {
			searchSet = getScenariosByTags(tagsString);
		}
		
		List<String> tags = getTagsFromStr(tagsString);
		
		while (!tags.isEmpty()){
			getScenarioWithMaxTags(found, searchSet, tags);
			
		}

		return found;
	}

	private static void getScenarioWithMaxTags(List<Scenario> found, List<Scenario> searchSet, List<String> tags) {
		for (int i = tags.size(); i > 0; i--){
			int tagsCount = i;
			Optional<Scenario> foundFirst = searchSet.stream().filter(sc -> getTagsFromStr(sc.getTitle()).size() == tagsCount).findFirst();
			if (!foundFirst.isPresent()) {
				continue;
			}
			Scenario scenario = foundFirst.get();
			found.add(scenario);
			searchSet.remove(scenario);
			tags.removeAll(getTagsFromStr(scenario.getTitle()));
			return;
		}
	}
	
	private static List<String> getTagsFromStr(String tagsString){
		return Arrays.stream(tagsString.split(TRIMMER))
				.map(str -> str.trim()).filter(str -> str.startsWith("#"))
				.collect(toList());
	}
}
