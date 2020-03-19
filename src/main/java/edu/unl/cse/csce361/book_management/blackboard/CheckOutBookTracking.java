package edu.unl.cse.csce361.book_management.blackboard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CheckOutBookTracking {
	private String cellNumber;
	private LocalDate checkOutDate;
	private LocalDate returnDate;

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public CheckOutBookTracking(String cellNumber, LocalDate checkOutDate, LocalDate returnDate) {
		super();
		this.cellNumber = cellNumber;
		this.checkOutDate = checkOutDate;
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		String title = null;
		String checkout = "";
		String returnDateString = "";
		String dueIn = "";
		for (int i = 0; i < Blackboard.inventory.size(); i++) {
			if (Objects.equals(Blackboard.inventory.get(i).getCallNumber(), cellNumber)) {
				title = Blackboard.inventory.get(i).getTitle();
			}
		}
		if (!checkOutDate.toString().equals("0001-01-01")) {
			checkout = checkOutDate.toString();
		}
		if (!returnDate.toString().equals("0001-01-01")) {
			returnDateString = returnDate.toString();
		} else {
			dueIn = ChronoUnit.DAYS.between(DateSetting.dayForNow, checkOutDate.plusDays(7)) + " Days";
		}

		return String.format("%-80s %-20s %-20s %7s", title, checkout, returnDateString, dueIn);
	}

}
