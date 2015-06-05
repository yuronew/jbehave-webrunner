package org.iasa.testing;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.model.Scenario;

public class SearchEngine {
	private static final String TRIMMER = " ";

	public static List<Scenario> getScenariosByTags(String tagsString) {
		if (tagsString.isEmpty()){
			return JBehaveWrapper.getDefaultScenarios();
		}
		
		List<String> tags = Arrays.stream(tagsString.split(TRIMMER))
				.map(str -> str.trim()).filter(str -> str.startsWith("#"))
				.collect(toList());
		List<Scenario> allScenarios = JBehaveWrapper.getDefaultScenarios();
		List<Scenario> found = allScenarios
				.stream()
				.filter(sc -> tags.stream()
						.filter(t -> sc.getTitle().contains(t)).findAny()
						.isPresent()).collect(toList());

		return found;
	}
}
