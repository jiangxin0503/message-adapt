package com.xin.message.model;

public class Tour {
	private String tourId;
	private String sourceLoc;
	private String destinationLoc;
	private String driver;
	private String vechicleId;
	private String plateNumber;
	private String status;
	
	private String changeMode; //New, Started, Completed
	
	public String getTourId() {
		return tourId;
	}
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}
	public String getSourceLoc() {
		return sourceLoc;
	}
	public void setSourceLoc(String sourceLoc) {
		this.sourceLoc = sourceLoc;
	}
	public String getDestinationLoc() {
		return destinationLoc;
	}
	public void setDestinationLoc(String destinationLoc) {
		this.destinationLoc = destinationLoc;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getVechicleId() {
		return vechicleId;
	}
	public void setVechicleId(String vechicleId) {
		this.vechicleId = vechicleId;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getChangeMode() {
		return changeMode;
	}
	public void setChangeMode(String changeMode) {
		this.changeMode = changeMode;
	}
	
	
	
}
