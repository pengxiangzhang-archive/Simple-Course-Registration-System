package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.PrintBook;

public class SortByTitle implements Command {

	@Override
	public void execute() {
		PrintBook.sortBooksByTitle();
	}

	@Override
	public String toString() {
		return "Sort by Title";
	}
}
