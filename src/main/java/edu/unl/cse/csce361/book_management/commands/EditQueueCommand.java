package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Librarian;

public class EditQueueCommand implements Command {

	@Override
	public void execute() {
		Librarian.editQueue();
	}

	@Override
	public String toString() {
		return "Edit Queue";
	}

}
