package edu.unl.cse.csce361.book_management.blackboard;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BookData implements Book {

	private String author;
	private String title;
	private String callNumber;
	private String status;
	private LocalDate dueDate;
	private String dueDateString = "";

	public LocalDate getDueDate() {
		return dueDate;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDueDate(LocalDate duedate) {
		this.dueDate = duedate;
	}

	@Override
	public String toString() {

		if (!dueDate.toString().equals("0001-01-01"))
			dueDateString = dueDate.toString();
		return String.format("%-20s %-80s %-15s %-15s %-11s", author, title, callNumber, status, dueDateString);
	}

	public Map<String, String> addMap() {
		Map<String, String> data = new HashMap<>();
		data.put("author", this.author);
		data.put("title", this.title);
		data.put("callNumber", this.callNumber);
		data.put("status", this.status);
		data.put("duedate", this.dueDate.toString());
		return data;
	}

	@Override
	public int compareTo(Object o) {
		BookData book = (BookData) o;
		return this.title.compareTo(book.title);
	}

}
