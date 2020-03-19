package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Librarian;

public class RemoveBookCommand implements Command {
	@Override
	public void execute() {
		Librarian.removeBook();
	}

	@Override
	public String toString() {
		return "Remove Book";
	}
}
