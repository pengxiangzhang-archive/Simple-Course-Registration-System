package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Librarian;

public class PrintWaitListCommand implements Command {

	@Override
	public void execute() {
		Librarian.printWaitList();
	}

	@Override
	public String toString() {
		return "Print Wait List";
	}

}
