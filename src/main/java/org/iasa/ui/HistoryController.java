package org.iasa.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.iasa.AppDirectory;
import org.iasa.testing.JBehaveWrapper;
import org.iasa.testing.JBehaveWrapper.Results;
import org.jbehave.core.model.Scenario;

@ManagedBean(name = "historyController")
public class HistoryController {
	//private Logger LOG = LoggerFactory.getLogger(ResultsController.class);
	private List<Scenario> scenarios;
	private Scenario selectedScenario;
	private Results results;

	@PostConstruct
	public void init() {
		setScenarios(JBehaveWrapper.getScenarios(AppDirectory.STORY_RUN_FOLDER.get()));
	}

	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}

	public Scenario getSelectedScenario() {
		return selectedScenario;
	}

	public void setSelectedScenario(Scenario selectedScenario) {
		this.selectedScenario = selectedScenario;
	}
	
	public void runAgain(){
		this.setResults(JBehaveWrapper.runScenarios());
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}
}
