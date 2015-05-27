package org.iasa;

public enum AppNames {
	STORY_FOLDER("src/main/resources/run/"), STORY_CANDIDATES_FOLDER("src/main/resources/candidates/");
	
	private String value;
	
	AppNames(String value){
		this.value = value;
	}
	
	public String get(){
		return value;
	}
}
