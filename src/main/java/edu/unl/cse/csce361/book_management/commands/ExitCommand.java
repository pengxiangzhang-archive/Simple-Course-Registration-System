package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.CLI;

public class ExitCommand implements Command {
	private CLI creator;

	public ExitCommand(CLI creator) {
		this.creator = creator;
	}

	@Override
	public void execute() {
		creator.terminate();
	}

	@Override
	public String toString() {
		return "Exit";
	}
}
