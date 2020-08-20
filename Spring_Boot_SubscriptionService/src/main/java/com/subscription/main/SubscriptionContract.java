package com.subscription.main;

import java.sql.Date;

public class SubscriptionContract {
	private final long book_id;
	private final String subscription_name;
	private final Date subscription_date;
	private final Date return_date;
	public long getBook_id() {
		return book_id;
	}
	public String getSubscription_name() {
		return subscription_name;
	}
	public Date getSubscription_date() {
		return subscription_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public SubscriptionContract(long book_id, String subscription_name, Date subscription_date, Date return_date) {
		super();
		this.book_id = book_id;
		this.subscription_name = subscription_name;
		this.subscription_date = subscription_date;
		this.return_date = return_date;
	}
	public SubscriptionContract() {
		super();
		// TODO Auto-generated constructor stub
		this.book_id = 0;
		this.subscription_name = "";
		this.subscription_date = null;
		this.return_date = null;
	}
	
}
