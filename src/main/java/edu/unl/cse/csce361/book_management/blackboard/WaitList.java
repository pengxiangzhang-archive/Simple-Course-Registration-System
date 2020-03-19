package edu.unl.cse.csce361.book_management.blackboard;

public class WaitList {

	String userName;
	String callNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	@Override
	public String toString() {
		return String.format("WaitList [userName: %s, callNumber: %s]", userName, callNumber);
	}

	public WaitList(String userName, String callNumber) {
		super();
		this.userName = userName;
		this.callNumber = callNumber;
	}

}
