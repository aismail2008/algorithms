package com.code.test.problemset.CrackingCodingInterview6.ch7.Q7_ChatServer;

public class GroupChat extends Conversation {
	public void removeParticipant(User user) {
		participants.remove(user);
	}
	
	public void addParticipant(User user) {
		participants.add(user);
	}
}
