package com.ratemycode.commands;

import java.util.UUID;

public class SocialDetails {

	private UUID id;
	private String fbURL;
	private String googleURL;
	private String twitterURL;
	private String linkedinURL;
	
	public String getFbURL() {
		return fbURL;
	}
	public void setFbURL(String fbURL) {
		this.fbURL = fbURL;
	}
	public String getGoogleURL() {
		return googleURL;
	}
	public void setGoogleURL(String googleURL) {
		this.googleURL = googleURL;
	}
	public String getTwitterURL() {
		return twitterURL;
	}
	public void setTwitterURL(String twitterURL) {
		this.twitterURL = twitterURL;
	}
	public String getLinkedinURL() {
		return linkedinURL;
	}
	public void setLinkedinURL(String linkedinURL) {
		this.linkedinURL = linkedinURL;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SocialDetails [fbURL=" + fbURL + ", googleURL=" + googleURL + ", twitterURL=" + twitterURL
				+ ", linkedinURL=" + linkedinURL + "]";
	}
	
}
