package edu.unl.cse.csce361.book_management.blackboard;

import java.time.LocalDate;

public class BookBuilder {
	private BookData book;
	private String defaultAuthor = "Anonymous";
	private String defaultTitle  = "Unknown";
	private String defaultStatus = "Unknown";
	private LocalDate defaultDueDate = LocalDate.of(0001, 01, 01);

	public BookBuilder() {
		this.book = new BookData();
	}

	public void setAuthor(String author) {
		this.book.setAuthor(author);
	}

	public void setTitle(String title) {
		this.book.setTitle(title);
	}

	public void setCallNumber(String callNumber) {
		this.book.setCallNumber(callNumber);
	}

	public void setStatus(String status) {
		this.book.setStatus(status);
	}

	public void setDueDate(LocalDate dueDate) {
		this.book.setDueDate(dueDate);
	}

	public void buildBook(){
		if(this.book.getStatus() == null){
			setStatus(defaultStatus);
		}
		if(this.book.getTitle() == null){
			setTitle(defaultTitle);
		}
		if(this.book.getAuthor() == null){
			setAuthor(defaultAuthor);
		}
		if(this.book.getDueDate() == null){
			setDueDate(defaultDueDate);
		}
	}

	public BookData getBook() {
		return this.book;
	}

}
