package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Librarian;

public class AddBookCommand implements Command {

	@Override
	public void execute() {
		Librarian.addBook();
	}

	@Override
	public String toString() {
		return "Add Book";
	}
}
