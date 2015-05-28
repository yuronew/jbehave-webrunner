package org.iasa.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.iasa.AppDirectory;
import org.iasa.testing.JBehaveWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "addController")
@ViewScoped
public class AddController {
	private static final String TEST_STORY_NAME = AppDirectory.STORY_TEST_FOLDER.get() + "out.story";
	private static final String SAVE_STORY_NAME = AppDirectory.STORY_ALL_FOLDER.get() + "added.story";
	private static final Logger LOG = LoggerFactory.getLogger(AddController.class);
	private String title;
	private String story;
	private boolean valid = false;

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
	public void test(){
		final String scenarioName = title;
		if (JBehaveWrapper.getDefaultScenarios().stream().filter(sc -> sc.getTitle().equals(scenarioName)).findAny().isPresent()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Scenario with this name already exists.", null));
			return;
		}
		
		if (save(TEST_STORY_NAME) != null){
			if(JBehaveWrapper.testScenarios()){
				append(SAVE_STORY_NAME);	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your scenario is valid and was added to framework."));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Steps for your scenario are not implemented yet.", null));
			}
		}
	}

	private String save(String path) {
		String fullPath = null;
		if (story != null && !story.isEmpty()) {
			File file = new File(path);
			fullPath = file.getAbsolutePath();
			LOG.info("Writing new story to " + fullPath);
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
				writer.write("Scenario: " + title + "\n");
				writer.write(story);
			} catch (IOException e) {
				LOG.error("Failed to save story", e);
			}
		}
		return fullPath;
	}
	
	private String append(String path) {
		String fullPath = null;
		if (story != null && !story.isEmpty()) {
			File file = new File(path);
			fullPath = file.getAbsolutePath();
			LOG.info("Writing new story to " + fullPath);
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)))) {
				out.write("Scenario: " + title + "\n");
				out.write(story);
			} catch (IOException e) {
				LOG.error("Failed to save story", e);
			}
		}
		return fullPath;
	}
	

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}