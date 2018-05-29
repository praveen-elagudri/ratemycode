package com.ratemycode.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


import java.io.Serializable;
import java.util.UUID;

@Table("jobdetails")
public class JobDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	//@CassandraType(type = DataType.Name.UUID)
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
	
	
	 public JobDetailsEntity() {
	        id = UUID.randomUUID();
	 }


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


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


	public void setEducation(String education) {
		this.education = education;
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


}



