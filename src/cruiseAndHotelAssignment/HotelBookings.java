package cruiseAndHotelAssignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HotelBookings extends MyBookings {

	@Override
	public void displaySelectedDetails() {
		System.out.println("Please select the from the following - Deluxe Suite or Family Suite"
				+ "\nDeluxe Suite: can accommodate two '2' adults and two '2' children at the rate " + "of $180/ night"
				+ "\nFamily Suite: can accommodate four '4' adults and" + " four '4' children at $230/ night");
	}

	public boolean getMealSelection(Scanner sc) {
		System.out.println(
				"All rooms come with free breakfast. Do you want to add lunch in your room as well at a discounted pre-booking rate of "
						+ "$25/ adult and " + "$5/ child?."
						+ "\nPlease enter 'Y' to prebook or enter any other input if you do not want to prebook.");

		String mealSelected = sc.nextLine();

		if (mealSelected.equalsIgnoreCase("Y")) {
			return isMealSelected = true;
		} else {
			return isMealSelected = false;
		}
	}

	@Override
	public double getTax() {
		return 0.18;
	}

	@Override
	public void setTax(double tax) {
		super.tax = tax;
	}

	@Override
	public double calculateTotalPrice(Scanner sc) {

		if (getMealSelection(sc)) {
			totalPrice = (noOfRooms * noOfDays * dailyPrice) + +(adultMealPrice * noOfAdults * noOfDays)
					+ (kidsMealPrice * noOfKids * noOfDays);
		} else {
			totalPrice = noOfDays * noOfRooms * dailyPrice;
		}
		return totalPrice;
	}

	@Override
	public void displayCalculatedPrice() {
		setTax(getTax());
		System.out.println("The total amount you will be charged is:");
		System.out.println(booking + "@ " + noOfDays + " nights:$"
				+ new DecimalFormat("0.00").format(dailyPrice * noOfRooms * noOfDays));
		if (isMealSelected) {
			System.out.println("Lunch Pre-Booked Special Rate Adults @ " + noOfAdults + "@$"
					+ new DecimalFormat("0.00").format(adultMealPrice * noOfAdults * noOfDays));
		}
		if (isMealSelected && noOfKids > 0) {
			System.out.println("Lunch Pre-Booked Special Rate Children	@ " + noOfKids + "@$"
					+ new DecimalFormat("0.00").format(kidsMealPrice * noOfKids * noOfDays));
		}

		System.out.println("Total Price:$" + new DecimalFormat("0.00").format(totalPrice) + "\nHST@18%:$"
				+ new DecimalFormat("0.00").format(totalPrice * tax) + "\nFinal Price:$"
				+ new DecimalFormat("0.00").format((totalPrice + totalPrice * tax)));

	}

}
