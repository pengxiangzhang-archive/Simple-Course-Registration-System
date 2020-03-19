package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Librarian;

public class EditCatalogEntryCommand implements Command {

	@Override
	public void execute() {
		Librarian.editCatalogEntry();
	}

	@Override
	public String toString() {
		return "Edit Catalog Entry";
	}
}
