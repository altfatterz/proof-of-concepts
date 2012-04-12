package com.infohubble.oauth.provider;

public class Organisation {

	private Long id;
	private String name;
	
	public Organisation(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
