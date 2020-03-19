package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Patron;

public class ViewCheckOutBookCommand implements Command {
	@Override
	public void execute() {
		Patron.viewCheckoutHistory();
	}

	@Override
	public String toString() {
		return "View Checked Out Book";
	}
}
