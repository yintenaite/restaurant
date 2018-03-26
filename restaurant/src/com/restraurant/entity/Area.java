package com.restraurant.entity;

public class Area {
	private int areaId;
	private String areaName;
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Area(int areaId) {
		super();
		this.areaId = areaId;
	}

	public Area(String areaName) {
		super();
		this.areaName = areaName;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}
