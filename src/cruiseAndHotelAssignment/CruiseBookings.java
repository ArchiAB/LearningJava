package cruiseAndHotelAssignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CruiseBookings extends MyBookings {

	@Override
	public void displaySelectedDetails() {
		System.out.println("The cruise that you have selected is " + booking + " which is a " + noOfDays
				+ " day cruise " + "\nPrice for Adults(greater than 12): " + adultDailyPrice
				+ " per day\nPrice for kids above 5: " + kidsDailyPrice + " per day"
				+ "\nPlease press Y and enter if you want to continue with the selection or press any other alphabet to select another.");
	}

	public int getNoOfAdults(Scanner sc) {
		System.out.println("Please enter the number of adults");
		noOfAdults = Integer.parseInt(sc.nextLine());
		return noOfAdults;
	}

	public boolean setNoOfAdults(Scanner sc, int noOfAdults) {
		String isSeparateBooking = null;
		this.noOfAdults = noOfAdults;
		if (noOfAdults == 0) {
			System.out.println(
					"You can not proceed with this booking with 0 adults. "
					+ "If you have already made separate booking for adults, enter 'Yes' or press any other alphabet to terminate operation.");
			isSeparateBooking = sc.nextLine();
		}
		if (noOfAdults != 0 || isSeparateBooking.equalsIgnoreCase("Yes")) {
			return true;
		} else {
			return false;
		}
	}

	public int getNoOfKids(Scanner sc) {
		int age = 0;
		System.out.println("Please enter the number of kids");
		int noOfKidsAllAges = Integer.parseInt(sc.nextLine());
		if (noOfKidsAllAges > 0) {
			for (int i = 1; i <= noOfKidsAllAges; i++) {
				System.out.println("Enter the age of Child " + i);
				age = Integer.parseInt(sc.nextLine().trim());
				if (age > 5 && age <= 12) {
					noOfKids += 1;
				}
			}
		}
		return noOfKids;
	}

	public void setNoOfKids(Scanner sc, int noOfKids) {
		this.noOfKids = noOfKids;
	}

	public boolean getMealSelection(Scanner sc) {

		System.out.println("All our cruises have food service on board. "
				+ "\nDo you want to pre-book for dinner buffet meals at 20.99 per day for adults and 4.99 per day for kids above 5 years?"
				+ "\nPlease enter Y to prebook or enter any other input if you do not want to prebook.");

		String mealSelected = sc.nextLine().trim();

		if (mealSelected.equalsIgnoreCase("Y")) {
			return isMealSelected = true;
		} else {
			return isMealSelected = false;
		}
	}

	@Override
	public double getTax() {
		return 0.15;
	}

	@Override
	public void setTax(double tax) {
		super.tax = tax;
	}

	@Override
	public double calculateTotalPrice(Scanner sc) {
		if (setNoOfAdults(sc, getNoOfAdults(sc))) {
			setNoOfKids(sc, getNoOfKids(sc));
			setAddOnCost(getAddOnCost(sc));
			if (getMealSelection(sc)) {
				totalPrice = (adultDailyPrice * noOfAdults * noOfDays) + (kidsDailyPrice * noOfKids * noOfDays)
						+ (adultMealPrice * noOfAdults * noOfDays) + (kidsMealPrice * noOfKids * noOfDays) + addOnPrice;
			} else {
				totalPrice = (adultDailyPrice * noOfAdults * noOfDays) + (kidsDailyPrice * noOfKids * noOfDays)
						+ addOnPrice;
			}
			return totalPrice;
		}
		return totalPrice = -1.0;
	}

	@Override
	public void displayCalculatedBills() {
		setTax(getTax());
		if (totalPrice != -1) {
			System.out.println("Your Package includes:");
			if (noOfAdults > 0) {
				System.out.println(booking + " Adults@" + noOfAdults + ":$"
						+ new DecimalFormat("0.00").format(adultDailyPrice * noOfAdults * noOfDays));
				if (isMealSelected) {
					System.out.println("Buffet Special Price Adults" + "@" + noOfAdults + ":$"
							+ new DecimalFormat("0.00").format(adultMealPrice * noOfAdults * noOfDays));
				}

			}
			if (noOfKids > 0) {
				System.out.println(booking + " Children above 5@" + noOfKids + ":$"
						+ new DecimalFormat("0.00").format(kidsDailyPrice * noOfKids * noOfDays));
				if (isMealSelected) {
					System.out.println("Buffet Special Price Children above 5" + "@" + noOfKids + ":$"
							+ new DecimalFormat("0.00").format(kidsMealPrice * noOfKids * noOfDays));
				}
			}

			if (addOnPrice != 0) {
				System.out.println(booking + " PreBooking Price of Add-on Service " + ":$" + addOnPrice);
			}

			System.out.println("Total Price:$" + new DecimalFormat("0.00").format(totalPrice) + "\nHST@15%:$"
					+ new DecimalFormat("0.00").format(totalPrice * tax) + "\nFinal Price:$"
					+ new DecimalFormat("0.00").format((totalPrice + totalPrice * tax)));

		}
	}

	@Override
	public void displayCalculatedPrice() {
		// TODO Auto-generated method stub

	}
}