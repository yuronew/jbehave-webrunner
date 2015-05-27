package org.iasa.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.iasa.AppNames;
import org.iasa.JBehaveWrapper;
import org.jbehave.core.model.Scenario;

@ManagedBean(name = "resultsController")
public class ResultsController {
	//private Logger LOG = LoggerFactory.getLogger(ResultsController.class);
	private List<Scenario> scenarios;

	@PostConstruct
	public void init() {
		setScenarios(JBehaveWrapper.getScenarios(AppNames.STORY_FOLDER.get()));
	}

	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}
}
