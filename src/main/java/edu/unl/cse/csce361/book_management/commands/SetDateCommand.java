package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.blackboard.DateSetting;

public class SetDateCommand implements Command {
	@Override
	public void execute() {
		DateSetting.setDate();
	}

	@Override
	public String toString() {
		return "Set Date";
	}
}
