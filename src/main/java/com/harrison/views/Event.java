package com.harrison.views;

import java.util.Map;

public class Event {
	
	private String id;
	
	private Map<String, String> esns;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getEsns() {
		return esns;
	}

	public void setEsns(Map<String, String> esns) {
		this.esns = esns;
	}

	
}
