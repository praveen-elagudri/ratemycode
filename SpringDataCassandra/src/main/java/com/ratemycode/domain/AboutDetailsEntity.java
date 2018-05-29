package com.ratemycode.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table("aboutdetails")
public class AboutDetailsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	//@CassandraType(type = DataType.Name.UUID)
	private UUID id;
	private String yearOfExp;
	private String profileVisibility;
	
	 public AboutDetailsEntity() {
	        id = UUID.randomUUID();
	 }
	
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
