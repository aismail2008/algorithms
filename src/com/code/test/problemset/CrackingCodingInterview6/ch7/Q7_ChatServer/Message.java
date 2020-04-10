package com.code.test.problemset.CrackingCodingInterview6.ch7.Q7_ChatServer;

import java.util.Date;

public class Message {
	private String content;
	private Date date;
	public Message(String content, Date date) {
		this.content = content;
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}
	
	public Date getDate() {
		return date;
	}
}
