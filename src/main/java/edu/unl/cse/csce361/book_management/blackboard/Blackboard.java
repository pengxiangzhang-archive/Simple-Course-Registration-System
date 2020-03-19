package edu.unl.cse.csce361.book_management.blackboard;

import edu.unl.cse.csce361.book_management.Observer;
import edu.unl.cse.csce361.book_management.Patron;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard {

    public static ArrayList<BookData> inventory = new ArrayList<>();
    public static ArrayList<WaitList> waitList = new ArrayList<>();
    public static ArrayList<CheckOutBookTracking> checkoutHistory = new ArrayList<>();


    public static Scanner scanner = new Scanner(System.in);

    public static void initialize(){
        DateSetting.setDate();
        CSVReaderWriter.readFile("books.csv");
    }


    public static void notifyObservers(String callNumber){
        Patron.update(callNumber);
    }

    static public void editBook(BookData book) {
        boolean exit = false;
        while (!exit) {
            System.out.println(
                    "0. Edit author \n1. Edit title\n2. Edit call number\n3. Edit status\n4. Edit due date\n5. Exit\nSelect a command:");
            int selection = Blackboard.scanner.nextInt();
            Blackboard.scanner.nextLine();
            switch (selection) {
                case 0:
                    System.out.println("Enter new author:");
                    String newAuthor = Blackboard.scanner.nextLine();
                    book.setAuthor(newAuthor);
                    break;

                case 1:
                    System.out.println("Enter new title:");
                    String newTitle = Blackboard.scanner.nextLine();
                    book.setTitle(newTitle);
                    break;

                case 2:
                    System.out.println("Enter new call number:");
                    String newCallNumber = Blackboard.scanner.nextLine();
                    book.setCallNumber(newCallNumber);
                    break;

                case 3:
                    System.out.println("Enter new status:");
                    String newStatus = Blackboard.scanner.nextLine();
                    book.setStatus(newStatus);
                    break;

                case 4:
                    System.out.println("Enter new due date:(YYYY-MM-DD)");
                    String newDue = Blackboard.scanner.nextLine();
                    book.setDueDate(LocalDate.parse(newDue));
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Please select an option from the list.");
            }
        }
        System.out.println("Edited Entry");
        System.out.println(
                String.format("%-20s %-80s %-15s %-15s %-11s", "Author", "Title", "Call Number", "Status", "Due Date"));
        System.out.println(book);
        Observer.update(book.getCallNumber());
    }
}
