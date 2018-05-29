package com.ratemycode.commands;

import java.util.UUID;

public class JobDetails {

	private UUID id;
	private String jobDescription;
	private String jobID;
	private String companyName;
	private String jobtitle;
	private String jobcategory;
	private String jobtype;
	private String salary;
	private String bonus;
	private String yearsExp;
	private String education;
	private String country;
	private String city;
	private String address;
	private String website;
	private long phone;
	private String email;
	private long fax;
	
	
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobcategory() {
		return jobcategory;
	}
	public void setJobcategory(String jobcategory) {
		this.jobcategory = jobcategory;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getEducation() {
		return education;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getFax() {
		return fax;
	}
	public void setFax(long fax) {
		this.fax = fax;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(String yearsExp) {
		this.yearsExp = yearsExp;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "JobDetails [jobtitle=" + jobtitle + ", jobcategory=" + jobcategory + ", jobtype=" + jobtype
				+ ", salary=" + salary + ", bonus=" + bonus + ", yearsExp=" + yearsExp + ", education=" + education
				+ ", country=" + country + ", city=" + city + ", address=" + address + ", website=" + website
				+ ", phone=" + phone + ", email=" + email + ", fax=" + fax + "]";
	}
	
	
}
