package edu.unl.cse.csce361.book_management.blackboard;

public interface Book extends Comparable<Object> {
	String getCallNumber();

	String getAuthor();

	String getTitle();
}
