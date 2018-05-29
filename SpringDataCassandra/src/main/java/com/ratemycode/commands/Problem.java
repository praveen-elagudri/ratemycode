package com.ratemycode.commands;

public class Problem {

	private String problemNo;
	private String percentage;
	private String level;
	private String title;
	
	
	public String getProblemNo() {
		return problemNo;
	}
	public void setProblemNo(String problemNo) {
		this.problemNo = problemNo;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Problem [problemNo=" + problemNo + ", percentage=" + percentage + ", level=" + level + ", title="
				+ title + "]";
	}
	
	
}
