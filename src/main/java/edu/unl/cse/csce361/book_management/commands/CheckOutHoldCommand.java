package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Patron;

public class CheckOutHoldCommand implements Command{
	@Override
	public void execute() {
		Patron.checkOutFromHold();
	}

	@Override
	public String toString() {
		return "Pick up hold book";

	}
}
