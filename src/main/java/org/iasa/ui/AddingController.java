package org.iasa.ui;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "addController")
@RequestScoped
public class AddingController {
	private static final String TEMPORARY_STORY = "temporary.story";

	private Logger LOG = LoggerFactory.getLogger(AddingController.class);

	private String story;

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public void save() {
		if (story != null && !story.isEmpty()) {
			LOG.info("Writing new story to " + TEMPORARY_STORY);
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TEMPORARY_STORY), "utf-8"))) {
				writer.write(story);
			} catch (IOException e) {
				LOG.error("Failed to save story", e);
			}
		}
	}
}
