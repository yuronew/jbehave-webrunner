package org.iasa.ui;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.iasa.JBehaveWrapper;
import org.jbehave.core.model.Scenario;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "runController")
public class RunController {
	private Logger LOG = LoggerFactory.getLogger(RunController.class);
	private DualListModel<Scenario> scenarios;

	@PostConstruct
	public void init() {
		setScenarios(new DualListModel<Scenario>(JBehaveWrapper.getDefaultScenarios(), new ArrayList<Scenario>()));
	}

	public void run() {
		LOG.info("Running scearios: " + scenarios.getTarget());
		JBehaveWrapper.writeRunningScenarios(scenarios.getTarget());
		JBehaveWrapper.runStories();
	}

	public DualListModel<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(DualListModel<Scenario> scenarios) {
		this.scenarios = scenarios;
	}
}
