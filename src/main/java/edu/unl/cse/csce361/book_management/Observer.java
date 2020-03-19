package edu.unl.cse.csce361.book_management;

import edu.unl.cse.csce361.book_management.blackboard.Blackboard;

public class Observer {
	public static void update(String callNumber) {
		String title = null;
		int arrLocation = 0;
		for (int i = 0; i < Blackboard.waitList.size(); i++) {
			if (Blackboard.waitList.get(i).getCallNumber().equals(callNumber)) {
				for (int j = 0; j < Blackboard.inventory.size(); j++) {
					if (Blackboard.inventory.get(j).getStatus().equals("Shelved")
							&& Blackboard.inventory.get(j).getCallNumber().equals(callNumber)) {
						title = Blackboard.inventory.get(j).getTitle();
						System.out.println("\nNotify!!");
						System.out.println(
								"Hi " + Blackboard.waitList.get(i).getUserName() + ",\nThe book you request <"
										+ title + "> is available, We put the book on hold for you to pickup.");
						Blackboard.inventory.get(j).setStatus("On Hold");
						Blackboard.waitList.remove(arrLocation);
						System.out.println("Here is the Task you have:\n1. Pick up book <" + title + ">\n2. Remove hold of the book");
						int selection = Blackboard.scanner.nextInt();
						Blackboard.scanner.nextLine();
						switch (selection) {
							case 1:
								Patron.checkOutBookFromHold(callNumber);
								break;
							case 2:
								Patron.removeOnHold(callNumber);
								break;
							default:
								System.out.println("You must complete the task first!");
						}
						return;
					}
				}
			}
		}

	}
}
