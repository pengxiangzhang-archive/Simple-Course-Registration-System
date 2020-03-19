package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.blackboard.*;

import java.time.LocalDate;

public class Librarian {

	static public void editCatalogEntry() {
		PrintBook.printNumberedCatalog();
		System.out.println("Select a book from the list:");
		boolean exit = false;
		while (!exit) {
			int input = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine();
			if (input >= 0 && input < Blackboard.inventory.size()) {
				BookData book = Blackboard.inventory.get(input);
				System.out.println(book);
				Blackboard.editBook(book);
				exit = true;
			} else {
				System.out.println("Please enter a number between 0 and " + (Blackboard.inventory.size() - 1));
			}
		}

	}


	public static void addBook() {
		BookBuilder builder = new BookBuilder();

		// title
		System.out.println("Enter the book's title:");
		String title = Blackboard.scanner.nextLine();
		builder.setTitle(title);

		// author
		System.out.println("Enter the book's author:");
		String author = Blackboard.scanner.nextLine();
		builder.setAuthor(author);

		// call number
		System.out.println("Enter the book's call number:");
		String callNumber = Blackboard.scanner.nextLine();
		builder.setCallNumber(callNumber);

		// status
		builder.setStatus("Shelved");

		// due date
		builder.setDueDate(LocalDate.of(0001, 01, 01));
		// build book
		BookData newBook = builder.getBook();
		Blackboard.inventory.add(newBook);
		System.out.println(newBook);
		Blackboard.notifyObservers(newBook.getCallNumber());
	}

	public static void removeBook() {
		PrintBook.printNumberedCatalog();
		System.out.println("Select a book to remove");
		boolean valid = false;
		int input = 0;
		while (!valid) {
			input = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine();
			if (input >= 0 && input < Blackboard.inventory.size()) {
				valid = true;
			} else {
				System.out.println("Please select a book from the list:");
			}
		}
		BookData bookToRemove = Blackboard.inventory.get(input);
		if (!bookToRemove.getStatus().equals("Shelved")) {
			System.out.println("Sorry, that book is not currently shelved.");
		} else {
			System.out.println("Remove the following book?: ");
			System.out.println(bookToRemove);
			// confirm
			System.out.println("Yes or No");
			if (Blackboard.scanner.nextLine().equalsIgnoreCase("yes")
					|| Blackboard.scanner.nextLine().equalsIgnoreCase("y")) {
				Blackboard.inventory.remove(input);
				System.out.println("Book removed.");
			}
		}
	}

	public static void editQueue() {

		if (Blackboard.waitList.isEmpty()) {
			System.out.println("Wait list is empty.\n");
			return;
		}

		System.out.println("Enter a patron's name: ");
		String name = Blackboard.scanner.nextLine();
		int index = 0;
		boolean found = false;
		WaitList topElement = null;
		while (index < Blackboard.waitList.size() && !found) {
			if (Blackboard.waitList.get(index).getUserName().contentEquals(name)) {
				topElement = Blackboard.waitList.get(index);
				found = true;
			} else {
				index++;
			}
		}
		System.out.println("Select an option:\n1. Remove from wait queue\n2. Move to top of wait queue\n");
		int selection = Blackboard.scanner.nextInt();
		Blackboard.scanner.hasNextLine();
		if (selection == 1) {
			Blackboard.waitList.remove(index);
		} else if (selection == 2) {
			Blackboard.waitList.remove(index);
			Blackboard.waitList.add(0, topElement);
		}

		System.out.println("Updated Wait List\n");
		printWaitList();
	}

	public static void printWaitList() {

		if (Blackboard.waitList.isEmpty()) {
			System.out.println("Wait list is empty.\n");
			return;
		}

		int i = 0;
		for (WaitList entry : Blackboard.waitList) {
			System.out.println(entry + " Priority: " + i);
			i++;
		}
	}

    public static void viewHoldList() {
        boolean exit = false;
        while (!exit) {
            boolean found = false;
            int count = 0;
            int hold = 0;
            int checkOut = 0;
            System.out.println("Please input the title of the book");
            String title = Blackboard.scanner.nextLine();
            for (int k = 0; k < Blackboard.inventory.size(); k++) {
                if (Blackboard.inventory.get(k).getTitle().equals(title)) {
                    found = true;
                    count++;
                    if (Blackboard.inventory.get(k).getStatus().equals("On Hold")) {
                        hold++;
                    }
                    if (Blackboard.inventory.get(k).getStatus().equals("Shelved")) {
                        checkOut++;
                    }

                }
            }
            if (found) {
                System.out.println(
                        "For title: " + title + "\n" + count + " copy(s) of the book found in the system.\n" + checkOut
                                + " copy available for checkout.\n" + hold + " students put the this book on hold.\n");
            } else
                System.out.println("Book not found in the system, Please double check the title.");
            System.out.println("1. Continue Searching\n2. Exit");
            int selection = Blackboard.scanner.nextInt();
            Blackboard.scanner.nextLine();
            switch (selection) {
                case 1:
                    break;
                case 2:
                    exit = true;
                default:
                    System.out.println("Please select an option from the list.");
                    break;
            }
        }
    }
}
