package edu.unl.cse.csce361.book_management.commands;

import edu.unl.cse.csce361.book_management.Patron;

public class AddBookToCartCommand implements Command {

	@Override
	public void execute() {
		Patron.addCart();
	}

	@Override
	public String toString() {
		return "Add Book To Cart";
	}
}
