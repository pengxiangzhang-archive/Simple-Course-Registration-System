package edu.unl.cse.csce361.book_management.blackboard;

import java.util.ArrayList;

public class PrintBook {
	public static void printNumberedCatalog() {
		System.out.println(String.format("%3s  %-20s %-80s %-15s %-15s %-11s", "#", "Author", "Title", "Call Number",
				"Status", "Due Date"));
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			System.out.println(String.format("%3d) %s", i, Blackboard.inventory.get(i)));
		}
		System.out.println();
	}

	public static void sortBooksByTitle() {

		ArrayList<BookData> bookList = new ArrayList<>(Blackboard.inventory);

		bookList.sort(BookData::compareTo);

		System.out.println(String.format("%3s  %-20s %-80s %-15s %-15s %-11s", "#", "Author", "Title", "Call Number",
				"Status", "Due Date"));
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(String.format("%3d) %s", i, bookList.get(i)));
		}
		System.out.println();
	}

}
