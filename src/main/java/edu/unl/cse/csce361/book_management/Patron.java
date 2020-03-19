package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.Observer;
import edu.unl.cse.csce361.book_management.blackboard.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Patron extends Observer {

	public static ArrayList<String> bookCart = new ArrayList<>();

	public static void addCart() {
		PrintBook.printNumberedCatalog();
		System.out.println("Please type in the number of the book.");
		int bookIndex = Blackboard.scanner.nextInt();
		Blackboard.scanner.nextLine();
		String callNumber = Blackboard.inventory.get(bookIndex).getCallNumber();
		bookCart.add(callNumber);
		for (int i = 0; i < bookCart.size(); i++) {
			System.out.println("In chart you have: ");
			System.out.println(String.format("%-20s %-80s %-15s %-15s", "Author", "Title", "Call Number", "Status"));

			for (String call : bookCart) {
				for (BookData book : Blackboard.inventory) {
					if (book.getCallNumber().equals(call)) {
						System.out.println(book);
					}
				}
			}
		}
	}

	public static void checkOutBookById(int bookCheckOutAction) {
		if (checkAvailable(bookCheckOutAction)) {
			Blackboard.inventory.get(bookCheckOutAction).setStatus("Checked Out");
			LocalDate dueDate = DateSetting.dayForNow.plusDays(7);
			CheckOutBookTracking checkOut = new CheckOutBookTracking(
					Blackboard.inventory.get(bookCheckOutAction).getCallNumber(), DateSetting.dayForNow,
					LocalDate.of(0001, 01, 01));
			Blackboard.checkoutHistory.add(checkOut);
			Blackboard.inventory.get(bookCheckOutAction).setDueDate(dueDate);
			System.out.println(String.format("%-20s %-80s %-15s %-15s %-11s", "Author", "Title", "Call Number",
					"Status", "Due Date"));
			System.out.println(Blackboard.inventory.get(bookCheckOutAction));
			System.out.println("Book checked out, Your due date is: " + dueDate);
		}
	}

	public static void checkOutBookFromHold(String callNumber) {
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getCallNumber().equals(callNumber)) {
				Blackboard.inventory.get(i).setStatus("Checked Out");
				LocalDate dueDate = DateSetting.dayForNow.plusDays(7);
				CheckOutBookTracking checkOut = new CheckOutBookTracking(
						Blackboard.inventory.get(i).getCallNumber(), DateSetting.dayForNow,
						LocalDate.of(0001, 01, 01));
				Blackboard.checkoutHistory.add(checkOut);
				Blackboard.inventory.get(i).setDueDate(dueDate);
				System.out.println(String.format("%-3s %-20s %-80s %-15s %-15s %-11s", "ID", "Author", "Title",
						"Call Number", "Status", "Due Date"));
				System.out.println(Blackboard.inventory.get(i));
				System.out.println("Book checked out, Your due date is: " + dueDate);
			}
		}
	}

	public static void removeOnHold(String callNumber) {
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getCallNumber().equalsIgnoreCase(callNumber)
					&& Blackboard.inventory.get(i).getStatus().equals("On Hold")) {
				Blackboard.inventory.get(i).setStatus("Shelved");
				Blackboard.inventory.get(i).setDueDate(LocalDate.of(0001, 01, 01));
				System.out.println("Request processed.");
				String callNum = Blackboard.inventory.get(i).getCallNumber();
				Blackboard.notifyObservers(callNum);
			}
		}
	}

	public static void putBookOnHoldById(int bookHoldAction) {
		if (checkAvailable(bookHoldAction)) {
			Blackboard.inventory.get(bookHoldAction).setStatus("On Hold");
			System.out.println(String.format("%-20s %-80s %-15s %-15s %-11s", "Author", "Title", "Call Number",
					"Status", "Due Date"));
			System.out.println(Blackboard.inventory.get(bookHoldAction));
			System.out.println("Request processed.");
		}
	}

	public static void checkOutBookSelection() {
		PrintBook.printNumberedCatalog();
		boolean exit = false;
		while (!exit) {
			System.out.println("Select an action:\n1. Check out the book\n2. Put book on hold\n0. Cancel");
			int action = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine(); // clear the line
			int bookId = -1;
			switch (action) {
			case 1:
				System.out.println("Please input the book ID");
				bookId = Blackboard.scanner.nextInt();
				Blackboard.scanner.nextLine();
				checkOutBookById(bookId);
				break;
			case 2:
				System.out.println("Please input the book ID");
				bookId = Blackboard.scanner.nextInt();
				Blackboard.scanner.nextLine();
				putBookOnHoldById(bookId);
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("Please select an option from the list.");
				break;
			}
		}
	}

	public static boolean checkAvailable(int bookID) {
		if (!Blackboard.inventory.get(bookID).getStatus().equals("Shelved")) {
			System.out.println("Book not available, do you want to be put on the wait list? (yes or no)");
			String selection = Blackboard.scanner.nextLine();
			if (selection.equalsIgnoreCase("yes")) {
				System.out.print("Please input your name:");
				String name = Blackboard.scanner.nextLine();
				WaitList addWaitList = new WaitList(name, Blackboard.inventory.get(bookID).getCallNumber());
				Blackboard.waitList.add(addWaitList);
				System.out.println("Request processed.");
				System.out.println("We will put the book on hold for you when it is available.");
			}
			return false;
		} else
			return true;
	}

	public static void returnBook() {
		int bookIndex = -1;
		String callNumber = null;
		PrintBook.printNumberedCatalog();
		System.out.println("Please input the books Call Number");
		String requestCallNumber = Blackboard.scanner.nextLine();
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getCallNumber().equalsIgnoreCase(requestCallNumber)
					&& Blackboard.inventory.get(i).getStatus().equals("Checked Out")) {
				Blackboard.inventory.get(i).setStatus("Shelved");
				for (int j = 0; j < Blackboard.checkoutHistory.size(); j++) {
					if (Objects.equals(Blackboard.inventory.get(i).getCallNumber(), Blackboard.checkoutHistory.get(j)
                            .getCellNumber())) {
						Blackboard.checkoutHistory.get(j).setReturnDate(DateSetting.dayForNow);
					}
				}
				Blackboard.inventory.get(i).setDueDate(LocalDate.of(0001, 01, 01));
				System.out.println("Request processed.");
				callNumber = Blackboard.inventory.get(i).getCallNumber();
			}
		}
		if (bookIndex == -1) {
			System.out.println("Request Failed. Please double check the Call Number.");
		}
		Blackboard.notifyObservers(callNumber);
	}

	public static void viewCheckoutHistory() {
		System.out
				.println(String.format("%-80s %-20s %-20s %-20s", "Title", "Check Out Date", "Return Date", "Due In"));
		for (int i = 0; i < Blackboard.checkoutHistory.size(); i++) {
			System.out.println(Blackboard.checkoutHistory.get(i));
		}
		System.out.println();
	}


	public static void removeHold() {
		System.out.println(
				String.format("%-20s %-80s %-15s %-15s %-11s", "Author", "Title", "Call Number", "Status", "Due Date"));
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getStatus().equals("On Hold")) {
				System.out.println(i + "  " + Blackboard.inventory.get(i).toString());
			}
		}
		System.out.print("In put the id that you need to remove from hold:");
		int idAction = Blackboard.scanner.nextInt();
		Blackboard.scanner.nextLine();
		Blackboard.inventory.get(idAction).setStatus("Shelved");
		System.out.println("Request Processed.");
	}

	public static void checkOutFromHold() {
		System.out.println(
				String.format("%-20s %-80s %-15s %-15s %-11s", "Author", "Title", "Call Number", "Status", "Due Date"));
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Blackboard.inventory.get(i).getStatus().equals("On Hold")) {
				System.out.println(Blackboard.inventory.get(i).toString());
			}
		}
		System.out.print("In put the Call Number that you want to check out:");
		String idAction = Blackboard.scanner.nextLine();
		checkOutBookFromHold(idAction);
	}
}
