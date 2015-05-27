package org.iasa.testing;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.iasa.AppDirectory;
import org.jbehave.core.io.LoadFromRelativeFile;

public class WebappStoryLoader extends LoadFromRelativeFile {

	public WebappStoryLoader() throws MalformedURLException {
		super(new URL("file://" + new File("").getAbsolutePath() + "/"));
	}

}
