package com.ratemycode.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


import java.io.Serializable;
import java.util.UUID;

@Table
public class SocialDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	//@CassandraType(type = DataType.Name.UUID)
	private UUID id;

	private String fbURL;
	private String googleURL;
	private String twitterURL;
	private String linkedinURL;
	
	 public SocialDetailsEntity() {
	        id = UUID.randomUUID();
	 }
	 
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

