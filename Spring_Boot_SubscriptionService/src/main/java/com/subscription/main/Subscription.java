package com.subscription.main;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "Subscription")
public class Subscription {
	
	@Id
	private String _id;
	private String subscriberName;
	private String bookId;
	private LocalDate dateSubscribed;
	private LocalDate dateReturned;
	private String notify;
	
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public LocalDate getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(LocalDate dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public LocalDate getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
}

