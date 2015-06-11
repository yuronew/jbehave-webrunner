package org.iasa.ui;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.iasa.testing.JBehaveWrapper;
import org.iasa.testing.JBehaveWrapper.Results;
import org.iasa.testing.SearchEngine;
import org.iasa.testing.pages.AbstractPage;
import org.jbehave.core.model.Scenario;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "runController")
public class RunController {
	private DualListModel<Scenario> scenarios;
	private Results results;
	private String searchString = "";
	private String searchMode = "max";

	@PostConstruct
	public void init() {
		setScenarios(new DualListModel<Scenario>(JBehaveWrapper.getDefaultScenarios(), new ArrayList<Scenario>()));
	}

	public void run() {
		JBehaveWrapper.writeRunningScenarios(scenarios.getTarget());
		this.results = JBehaveWrapper.runScenarios();
	}
	
	public void reloadWebdriver() {
		AbstractPage.reloadWebDriver();
	}
	
	public void search() {
		
		switch (searchMode) {
			case "max":
				setScenarios(new DualListModel<Scenario>(SearchEngine.getScenariosByTags(searchString), getScenarios().getTarget()));
				break;
			case "min":
//				FacesContext.getCurrentInstance().addMessage("searchError", 
//						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not implemented yet.", null));
				setScenarios(new DualListModel<Scenario>(SearchEngine.getMinScenariosByTags(searchString), getScenarios().getTarget()));
		}
			
	}

	public DualListModel<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(DualListModel<Scenario> scenarios) {
		this.scenarios = scenarios;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchMode() {
		return searchMode;
	}

	public void setSearchMode(String searchMode) {
		this.searchMode = searchMode;
	}
}
