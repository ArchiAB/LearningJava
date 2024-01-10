package cruiseAndHotelAssignment;

import java.util.Scanner;

public class ScenicCruise extends CruiseBookings {

	public ScenicCruise() {
		super.booking = getBooking();
		super.noOfDays = getNoOfDays();
		super.adultDailyPrice = getAdultDailyPrice();
		super.kidsDailyPrice = getKidDailyPrice();
		super.adultMealPrice = getAdultMealPrice();
		super.kidsMealPrice = getKidMealPrice();
	}

	public String getBooking() {
		booking = "Scenic Cruise";
		return booking;
	}

	public int getNoOfDays() {
		noOfDays = 3;
		return noOfDays;
	}

	public double getAdultDailyPrice() {
		adultDailyPrice = 43.99;
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
				"Do you want to pre-book our Spa sevices at the cost of $50 per session per person."
				+ "\nPlease enter Y to prebook or enter any other input if you do not want to prebook.");
		double spaCost = 50.00;
		String addOnRequired = sc.nextLine().trim();
		if (addOnRequired.equalsIgnoreCase("Y")) {
			System.out.println(
					"Please select number of persons.Kids under five can accompany you for free but can not avail services.");
			int noOfPeople = Integer.parseInt(sc.nextLine().trim());
			while (noOfPeople > noOfAdults + noOfKids) {
				System.out.println(
						"Numbers of persons can not be more than total of number of adults and number of kids above five.");
				noOfPeople = Integer.parseInt(sc.nextLine().trim());
			}
			System.out.println("Please select total number of sessions required altogether.");
			int noOfSessions = Integer.parseInt(sc.nextLine().trim());
			addOnPrice = noOfSessions * noOfPeople * spaCost;
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
