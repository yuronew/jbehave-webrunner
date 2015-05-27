package org.iasa;

public enum AppDirectory {
	STORY_RUN_FOLDER("src/main/resources/run/"), 
	STORY_ALL_FOLDER("src/main/resources/all/"),
	STORY_TEST_FOLDER("src/main/resources/new/");
	
	private String value;
	
	AppDirectory(String value){
		this.value = value;
	}
	
	public String get(){
		return value;
	}
}
