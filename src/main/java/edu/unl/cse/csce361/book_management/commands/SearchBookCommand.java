package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.SearchBook;

public class SearchBookCommand implements Command {
	@Override
	public void execute() {
		SearchBook.findBook();
	}

	@Override
	public String toString() {
		return "Search Book";
	}
}
