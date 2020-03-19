package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Librarian;

public class HoldListCommand implements Command {
	@Override
	public void execute() {
		Librarian.viewHoldList();
	}

	@Override
	public String toString() {
		return "View hold list";
	}
}
