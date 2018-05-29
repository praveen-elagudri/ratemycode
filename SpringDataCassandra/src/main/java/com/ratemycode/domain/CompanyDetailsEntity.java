package com.ratemycode.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table("companydetails")
public class CompanyDetailsEntity implements Serializable {

private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	//@CassandraType(type = DataType.Name.UUID)
	private UUID id;
	private String companyname;
	private String businesstype;
	private long busregnumber;
	private Date datefounded;
	private long noofemployees;
	private String country;
	private String city;
	private String address;
	private String website;
	private long phone;
	private String email;
	private long fax;
	private String fburl;
	private String googleurl;
	private String twitterurl;
	private String linkedinurl;
	
	
	public CompanyDetailsEntity() {
        id = UUID.randomUUID();
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
	
	public String getCompanyname() {
		return companyname;
	}



	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}



	public String getBusinesstype() {
		return businesstype;
	}



	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}



	public long getBusregnumber() {
		return busregnumber;
	}



	public void setBusregnumber(long busregnumber) {
		this.busregnumber = busregnumber;
	}



	public Date getDatefounded() {
		return datefounded;
	}



	public void setDatefounded(Date datefounded) {
		this.datefounded = datefounded;
	}



	public long getNoofemployees() {
		return noofemployees;
	}



	public void setNoofemployees(long noofemployees) {
		this.noofemployees = noofemployees;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
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



	public String getFburl() {
		return fburl;
	}



	public void setFburl(String fburl) {
		this.fburl = fburl;
	}



	public String getGoogleurl() {
		return googleurl;
	}



	public void setGoogleurl(String googleurl) {
		this.googleurl = googleurl;
	}



	public String getTwitterurl() {
		return twitterurl;
	}



	public void setTwitterurl(String twitterurl) {
		this.twitterurl = twitterurl;
	}



	public String getLinkedinurl() {
		return linkedinurl;
	}



	public void setLinkedinurl(String linkedinurl) {
		this.linkedinurl = linkedinurl;
	}

	
	
}
