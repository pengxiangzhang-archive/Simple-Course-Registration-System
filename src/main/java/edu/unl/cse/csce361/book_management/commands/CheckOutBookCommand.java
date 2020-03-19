package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Patron;

public class CheckOutBookCommand implements Command {

	@Override
	public void execute() {
		Patron.checkOutBookSelection();
	}

	@Override
	public String toString() {
		return "Check Out Book";
	}
}