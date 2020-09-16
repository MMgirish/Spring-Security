package com.ons.springsecurity.rest;

public class RestAsset {

	private long id;
	private String assetId;
	private String assetName;
	private String assetType;
	private String assetDescription;
	private String assignedBy;
	
	public RestAsset() {
		// TODO Auto-generated constructor stub
	}
	
	public RestAsset(long id, String assetId, String assetName, String assetType, String assetDescription, String assignedBy) {
		super();
		this.id = id;
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetType = assetType;
		this.assetDescription = assetDescription;
		this.assignedBy = assignedBy;
	}
	
	//getters,setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDesc) {
		this.assetDescription = assetDesc;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	
}
