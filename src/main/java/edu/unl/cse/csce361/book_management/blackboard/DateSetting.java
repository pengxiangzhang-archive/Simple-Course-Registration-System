package edu.unl.cse.csce361.book_management.blackboard;

import java.time.LocalDate;

public class DateSetting {
	public static LocalDate dayForNow;
	private static boolean hasDefultDate = false;

	public static void setDate() {

		if (!hasDefultDate) {
			dayForNow = LocalDate.now();
			System.out.println("Today is：" + dayForNow);
			hasDefultDate = true;
		}

		else {
			int year = 1;
			int month = 1;
			int day = 1;
			System.out.println("Please Enter the year(YYYY)");
			year = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine();

			System.out.println("Month(MM)");
			month = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine();

			System.out.println("Day(DD)");
			day = Blackboard.scanner.nextInt();
			Blackboard.scanner.nextLine();
			dayForNow = LocalDate.of(year, month, day);
			System.out.println("Date set to: " + dayForNow);
		}
	}

}
