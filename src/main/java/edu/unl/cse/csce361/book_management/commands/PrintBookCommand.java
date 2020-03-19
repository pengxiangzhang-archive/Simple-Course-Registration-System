package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.PrintBook;

public class PrintBookCommand implements Command {
	@Override
	public void execute() {
		PrintBook.printNumberedCatalog();
	}

	@Override
	public String toString() {
		return "Book List";
	}
}
