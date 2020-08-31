package com.user.auth.model;

import java.io.Serializable;

public class AuthResponse implements Serializable  {

	private String jwttoken;

	public AuthResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}
