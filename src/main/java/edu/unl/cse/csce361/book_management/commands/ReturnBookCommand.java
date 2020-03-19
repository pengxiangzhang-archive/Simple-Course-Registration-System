package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Patron;

public class ReturnBookCommand implements Command {
	@Override
	public void execute() {
		Patron.returnBook();
	}

	@Override
	public String toString() {
		return "Return Book";
	}
}
