package com.ons.springsecurity.rest;

import java.util.List;

public class RestUser {
	
	private long id;
	private String userId;
	private List<RestAsset> assets;
	
	public RestUser() {
		// TODO Auto-generated constructor stub
	}	
	
	public RestUser(long id, String userId) {
		super();
		this.id = id;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RestAsset> getAssets() {
		return assets;
	}

	public void setAssets(List<RestAsset> assets) {
		this.assets = assets;
	}
	

}
