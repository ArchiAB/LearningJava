package cruiseAndHotelAssignment;

import java.util.Scanner;

public class SunsetCruise extends CruiseBookings {
	public SunsetCruise() {
		super.booking = getBooking();
		super.noOfDays = getNoOfDays();
		super.adultDailyPrice = getAdultDailyPrice();
		super.kidsDailyPrice = getKidDailyPrice();
		super.adultMealPrice = getAdultMealPrice();
		super.kidsMealPrice = getKidMealPrice();
	}

	public String getBooking() {
		booking = "Sunset Cruise";
		return booking;
	}

	public int getNoOfDays() {
		noOfDays = 1;
		return noOfDays;
	}

	public double getAdultDailyPrice() {
		adultDailyPrice = 52.99;
		return adultDailyPrice;
	}

	public double getKidDailyPrice() {
		kidsDailyPrice = 15.99;
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

	public double getAddOnCost(Scanner sc) {
		System.out.println(
				"Do you want to pre-book special Candle Light Dinner at the cost of $45 per person."
				+ "\nPlease enter Y to prebook or enter any other input if you do not want to prebook.");
		double dinnerCost = 45.00;
		String addOnRequired = sc.nextLine().trim();
		if (addOnRequired.equalsIgnoreCase("Y")) {
			System.out.println(
					"Please select number of persons. Kids under five can accompany you for free, no need to include them here");
			int noOfPeople = Integer.parseInt(sc.nextLine().trim());
			while (noOfPeople > noOfAdults + noOfKids) {
				System.out.println(
						"Numbers of persons can not be more than total of number of adults and number of kids above five. Please select number of persons again.");
				noOfPeople = Integer.parseInt(sc.nextLine().trim());
			}
			addOnPrice = noOfPeople * dinnerCost;
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
