package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.blackboard.Blackboard;
import edu.unl.cse.csce361.book_management.commands.*;

import java.util.ArrayList;
import java.util.List;

public class CLI {
	private List<Command> commands;
	private boolean running;

	public CLI() {
		commands = new ArrayList<>();
		addInitialCommands();
		running = true;
	}

	public void addCommand(Command command) {
		commands.add(command);
	}

	public void removeCommand(Command command) {
		commands.remove(command);
	}

	public void terminate() {
		running = false;
	}

	private void addInitialCommands() {
		addCommand(new ExitCommand(this));
		addCommand(new SetDateCommand());
		addCommand(new PrintBookCommand());
		addCommand(new SearchBookCommand());
		addCommand(new AddBookToCartCommand());
		addCommand(new ReturnBookCommand());
		addCommand(new EditCatalogEntryCommand());
		addCommand(new AddBookCommand());
		addCommand(new RemoveBookCommand());
		addCommand(new CheckOutBookCommand());
		addCommand(new ViewCheckOutBookCommand());
		addCommand(new HoldListCommand());
		addCommand(new RemoveHoldCommand());
		addCommand(new CheckOutHoldCommand());
		addCommand(new SortByTitle());
		addCommand(new EditQueueCommand());
		addCommand(new PrintWaitListCommand());
	}

	private void run() {
		// initialize
		Blackboard.initialize();
		while (running) {
			for (int i = 0; i < commands.size(); i++) {
				System.out.println(i + ". " + commands.get(i));
			}
			System.out.println("Select a command: ");
			int input = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine();
			if (input >= 0 && input < commands.size()) {
				System.out.println("Command " + input + " selected!");
				commands.get(input).execute();
			} else {
				System.out.println("Please input a number to select a command");
			}
		}
		Blackboard.scanner.close();
	}

	public static void main(String[] args) {
		new CLI().run();
	}
}