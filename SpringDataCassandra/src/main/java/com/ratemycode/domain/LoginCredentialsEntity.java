package com.ratemycode.domain;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


import java.io.Serializable;
import java.util.UUID;

@Table("logindetails")
public class LoginCredentialsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	//@CassandraType(type = DataType.Name.UUID)
	private UUID id;
	private String email;
	private String password;
	
	 public LoginCredentialsEntity() {
	        id = UUID.randomUUID();
	 }
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	
}

