package com.user.main;

public class UserContract {

	private final long user_id;
	private final String subscription_name;
	private final String user_email;
	private final String user_password;

	
	public UserContract() {
		super();
		// TODO Auto-generated constructor stub
		this.user_id = 0;
		this.subscription_name = "";
		this.user_email = "";
		this.user_password = "";
	}
	
	public UserContract(long user_id, String subscription_name, String user_email, String user_password) {
		super();
		this.user_id = user_id;
		this.subscription_name = subscription_name;
		this.user_email = user_email;
		this.user_password = user_password;
	}
	public long getUser_id() {
		return user_id;
	}
	public String getSubscription_name() {
		return subscription_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	
}
