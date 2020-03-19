package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Patron;

public class RemoveHoldCommand implements Command {
	@Override
	public void execute() {
		Patron.removeHold();
	}

	@Override
	public String toString() {
		return "Remove Hold";

	}
}
