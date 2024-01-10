package cruiseAndHotelAssignment;

import java.util.Scanner;

public abstract class MyBookings {

	String booking;

	int noOfDays;

	double tax, adultDailyPrice, adultMealPrice, kidsDailyPrice, kidsMealPrice, dailyPrice, totalPrice;

	int noOfAdults, noOfKids, noOfRooms;

	double addOnPrice;

	boolean isMealSelected;

	public abstract void displaySelectedDetails();

	public double getAddOnCost(Scanner sc) {
		return addOnPrice;
	}

	public void setAddOnCost(double addOnCost) {
		this.addOnPrice = addOnCost;
	}

	public abstract double getTax();

	public abstract void setTax(double tax);

	public abstract double calculateTotalPrice(Scanner sc);

	public abstract void displayCalculatedPrice();

	public void displayCalculatedBills() {

	}
}