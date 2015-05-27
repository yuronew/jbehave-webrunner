package org.iasa.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.iasa.AppDirectory;
import org.iasa.testing.JBehaveWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "addController")
@RequestScoped
public class AddController {
	private static final String TEST_STORY_NAME = AppDirectory.STORY_TEST_FOLDER.get() + "out.story";
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
		if (save(TEST_STORY_NAME) != null){
			valid = JBehaveWrapper.testScenarios();
		}
	}

	private String save(String path) {
		String fullPath = null;
		if (story != null && !story.isEmpty()) {
			File file = new File(path);
			fullPath = file.getAbsolutePath();
			LOG.info("Writing new story to " + fullPath);
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))) {
				writer.write(story);
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