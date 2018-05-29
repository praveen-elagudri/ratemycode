package com.ratemycode.commands;

import java.util.Date;
import java.util.UUID;

public class CompanyDetails {

	private UUID id;
	private String companyName;
	private String businessType;
	private long busRegNumber;
	private Date dateFounded;
	private long noOfEmployees;
	private String country;
	private String city;
	private String address;
	private String website;
	private long phone;
	private String email;
	private long fax;
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
	
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	public long getBusRegNumber() {
		return busRegNumber;
	}
	public void setBusRegNumber(long busRegNumber) {
		this.busRegNumber = busRegNumber;
	}
	public Date getDateFounded() {
		return dateFounded;
	}
	public void setDateFounded(Date dateFounded) {
		this.dateFounded = dateFounded;
	}
	public long getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(long noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public long getFax() {
		return fax;
	}
	public void setFax(long fax) {
		this.fax = fax;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName + ", businessType=" + businessType + ", busRegNumber="
				+ busRegNumber + ", dateFounded=" + dateFounded + ", noOfEmployees=" + noOfEmployees + ", country="
				+ country + ", city=" + city + ", address=" + address + ", website=" + website + ", phone=" + phone
				+ ", email=" + email + ", fax=" + fax + "]";
	}
	
	
}
