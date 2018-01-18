package com.sap.fd.message.model;

public class Notification {
	
	private String toUser;
	private String toUserMobile;
	private String toUserPic;
	private String fromUser;
	private String fromUserMobile;
	private String fromUserPic;
	private String priority;
	private String message;
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getToUserMobile() {
		return toUserMobile;
	}
	public void setToUserMobile(String toUserMobile) {
		this.toUserMobile = toUserMobile;
	}
	public String getToUserPic() {
		return toUserPic;
	}
	public void setToUserPic(String toUserPic) {
		this.toUserPic = toUserPic;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getFromUserMobile() {
		return fromUserMobile;
	}
	public void setFromUserMobile(String fromUserMobile) {
		this.fromUserMobile = fromUserMobile;
	}
	public String getFromUserPic() {
		return fromUserPic;
	}
	public void setFromUserPic(String fromUserPic) {
		this.fromUserPic = fromUserPic;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
