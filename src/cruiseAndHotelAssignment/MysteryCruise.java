package cruiseAndHotelAssignment;

import java.util.Scanner;

public class MysteryCruise extends CruiseBookings {

	public MysteryCruise() {
		super.booking = getBooking();
		super.noOfDays = getNoOfDays();
		super.adultDailyPrice = getAdultDailyPrice();
		super.kidsDailyPrice = getKidDailyPrice();
		super.adultMealPrice = getAdultMealPrice();
		super.kidsMealPrice = getKidMealPrice();

	}

	public String getBooking() {
		booking = "Mystery Cruise";
		return booking;
	}

	public int getNoOfDays() {
		noOfDays = 2;
		return noOfDays;
	}

	public double getAdultDailyPrice() {
		adultDailyPrice = 45.99;
		return adultDailyPrice;
	}

	public double getKidDailyPrice() {
		kidsDailyPrice = 12.99;
		return kidsDailyPrice;
	}

	public double getAdultMealPrice() {
		adultMealPrice = 20.99;
		return adultMealPrice;
	}

	public double getKidMealPrice() {
		kidsMealPrice = 4.99;
		return kidsMealPrice;
	}

	@Override
	public double getAddOnCost(Scanner sc) {
		System.out.println(
				"Do you want to pre-book our Casino at one time entry fee of $20 per person."
				+ "\nEntry is allowed only for those above 18 years old with valid ID card."
				+ "\nPlease enter Y to prebook or enter any other input if you do not want to prebook.");
		double casinoFee = 20.00;
		String addOnRequired = sc.nextLine().trim();
		if (addOnRequired.equalsIgnoreCase("Y")) {
			System.out.println("Please select number of persons.");
			int noOfPeople = Integer.parseInt(sc.nextLine().trim());
			while (noOfPeople > noOfAdults) {
				System.out.println(
						"Numbers of persons can not be more than total number of adults. Please select number of persons again.");
				noOfPeople = Integer.parseInt(sc.nextLine().trim());
			}
			addOnPrice = noOfPeople * casinoFee;
			return addOnPrice;
		} else {
			return addOnPrice = 0;
		}
	}

	@Override
	public void setAddOnCost(double addOnCost) {
		super.addOnPrice = addOnCost;

	}
}
