package edu.unl.cse.csce361.book_management.blackboard;

public class SearchBook {

	public static void findBook() {
		boolean exit = false;
		while (!exit) {
			System.out.println("1. Search by Title\n2. Search by Author\n0. exit");
			int input = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine(); // clear the line

			switch (input) {
			case 0:
				exit = true;
				break;
			case 1:
				System.out.println("Please input the keyword");
				String keyword = Blackboard.scanner.nextLine();
				System.out.println(String.format("%-3s %-20s %-80s %-15s %-15s %-11s", "ID", "Author", "Title",
						"Call Number", "Status", "Due Date"));
				findBookIdByTitle(keyword);
				break;

			case 2:
				System.out.println("Please input the keyword");
				keyword = Blackboard.scanner.nextLine();
				System.out.println(String.format("%-3s %-20s %-80s %-15s %-15s %-11s", "ID", "Author", "Title",
						"Call Number", "Status", "Due Date"));

				findBookIdByAuthor(keyword);
				break;

			default:
				System.out.println("Please select an option from the list.");
				break;
			}
		}

	}

	public static void findBookIdByAuthor(String author) {
		boolean bookNotFound = true;
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getAuthor().toLowerCase().contains(author.toLowerCase())) {
				System.out.println(Blackboard.inventory.get(i));
				bookNotFound = false;
			}
		}
		if (bookNotFound)
			System.out.println("Book Not Found");
	}

	public static void findBookIdByTitle(String title) {
		boolean bookNotFound = true;
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
				System.out.println(Blackboard.inventory.get(i));
				bookNotFound = false;
			}
		}
		if (bookNotFound)
			System.out.println("Book Not Found");
	}

}
