package org.iasa.ui;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.iasa.testing.JBehaveWrapper;
import org.jbehave.core.model.Scenario;

@FacesConverter(value="scenarioConverter")
public class ScenariosConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Optional<Scenario> scenario = JBehaveWrapper.getDefaultScenarios().stream().filter(sc -> sc.getTitle().equals(arg2)).findAny();
		if (!scenario.isPresent()){
			return null;
		}
		return scenario.get();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Scenario){
			return ((Scenario)arg2).getTitle();
		} 
		return "Not a valid scenario";
	}

}
