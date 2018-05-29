package com.ratemycode.commands;

import java.util.UUID;

public class AboutDetails {

	private UUID id;
	private String yearOfExp;
	private String profileVisibility;
	
	public String getYearOfExp() {
		return yearOfExp;
	}
	public void setYearOfExp(String yearOfExp) {
		this.yearOfExp = yearOfExp;
	}
	public String getProfileVisibility() {
		return profileVisibility;
	}
	public void setProfileVisibility(String profileVisibility) {
		this.profileVisibility = profileVisibility;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AboutDetails [yearOfExp=" + yearOfExp + ", profileVisibility=" + profileVisibility + "]";
	}	
}
