package org.iasa.testing;

import static java.util.Arrays.asList;

import org.iasa.AppNames;
import org.iasa.testing.StepsRunner.MyReportBuilder;
import org.iasa.testing.pages.AbstractPage;
import org.iasa.testing.steps.RegisterSteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@Configure(storyReporterBuilder = MyReportBuilder.class)
@UsingSteps(instances = {RegisterSteps.class})
public class StepsRunner implements Embeddable {
	private Embedder embedder;
	 
    public void useEmbedder(Embedder embedder) {
        this.embedder = embedder;
    }
 
    @Test
    public void run() {
    	try{
    		embedder.runStoriesAsPaths(new StoryFinder().findPaths(AppNames.STORY_FOLDER.get(), asList("*.story"), asList("")));
    	} finally{
    		AbstractPage.quit();
		}
        
    }
    
    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(org.jbehave.core.reporters.Format.CONSOLE, org.jbehave.core.reporters.Format.HTML, org.jbehave.core.reporters.Format.STATS);
        }
    }
}
