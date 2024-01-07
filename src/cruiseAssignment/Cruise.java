package cruiseAssignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Cruise {
	Scanner sc = new Scanner(System.in);

	String nameOfCruise;
	int numberOfDays;
	double adultSelectedCruisePricePerDay;
	double childAboveFiveSelectedCruisePricePerDay;
	double dailyMealPriceForAdult = 20.99;
	double dailyMealPriceForChildAboveFive = 4.99;
	int numberOfAdults;
	int numberOfChildrenAboveFive;
	String mealSelection;
	double totalBill;

	public Cruise(String nameOfCruise, int numberOfDays, double adultSelectedCruisePricePerDay,
			double childAboveFiveSelectedCruisePricePerDay) {
		this.nameOfCruise = nameOfCruise;
		this.numberOfDays = numberOfDays;
		this.adultSelectedCruisePricePerDay = adultSelectedCruisePricePerDay;
		this.childAboveFiveSelectedCruisePricePerDay = childAboveFiveSelectedCruisePricePerDay;
	}

	public Cruise() {
	};

	public void displaySelectedCruiseDetails() {
		System.out.println("The cruise that you have selected is " + nameOfCruise + " which is a " + numberOfDays
				+ " days cruise \nPrice for Adults(greater than 12)\t: " + adultSelectedCruisePricePerDay
				+ " per day\nPrice for kids above 5\t\t\t: " + childAboveFiveSelectedCruisePricePerDay + " per day");

	}

	public void setNumberOfAdults(int numberOfAdultsByUser) {
		this.numberOfAdults = numberOfAdultsByUser;
	}

	public void setNumberOfChildrenAboveFive(int numberOfChildrenByUser) {
		int noOfChildrenAboveFive = 0;
		int age;
		if (numberOfChildrenByUser > 0) {
			for (int i = 1; i <= numberOfChildrenByUser; i++) {
				System.out.println("Enter the age of Child " + i);
				age = sc.nextInt();
				if (age > 5 && age <= 12) {
					noOfChildrenAboveFive += 1;
				}
			}
		}
		this.numberOfChildrenAboveFive = noOfChildrenAboveFive;
	}

	public void setMealSelection(String mealSelectionDone) {
		this.mealSelection = mealSelectionDone;
	}

	public double getTotalBill() {
		if (mealSelection.equalsIgnoreCase("Yes")) {
			totalBill = adultSelectedCruisePricePerDay * numberOfAdults * numberOfDays
					+ childAboveFiveSelectedCruisePricePerDay * numberOfChildrenAboveFive * numberOfDays
					+ dailyMealPriceForAdult * numberOfAdults * numberOfDays
					+ dailyMealPriceForChildAboveFive * numberOfChildrenAboveFive * numberOfDays;
		} else {
			totalBill = adultSelectedCruisePricePerDay * numberOfAdults * numberOfDays
					+ childAboveFiveSelectedCruisePricePerDay * numberOfChildrenAboveFive * numberOfDays;
		}
		return totalBill;
	}

	public void displayCalculatedBill() {
		System.out.println("Your Package includes:");
		if (numberOfAdults > 0) {
			System.out.println(nameOfCruise + " Adults\t\t\t@\t" + numberOfAdults + "\t:$"
					+ new DecimalFormat("0.00").format(adultSelectedCruisePricePerDay * numberOfAdults * numberOfDays));
			if (mealSelection.equalsIgnoreCase("Yes")) {
				System.out.println("Buffet Special Price Adults" + "\t\t@\t" + numberOfAdults + "\t:$"
						+ new DecimalFormat("0.00").format(dailyMealPriceForAdult * numberOfAdults * numberOfDays));
			}

		}
		if (numberOfChildrenAboveFive > 0) {
			System.out.println(nameOfCruise + " Children above 5\t\t@\t" + numberOfChildrenAboveFive + "\t:$"
					+ new DecimalFormat("0.00").format(
							childAboveFiveSelectedCruisePricePerDay * numberOfChildrenAboveFive * numberOfDays));
			if (mealSelection.equalsIgnoreCase("Yes")) {
				System.out.println("Buffet Special Price Children above 5" + "\t@\t" + numberOfChildrenAboveFive
						+ "\t:$" + new DecimalFormat("0.00")
								.format(dailyMealPriceForChildAboveFive * numberOfChildrenAboveFive * numberOfDays));
			}
		}

		System.out.println("Total Price\t\t\t\t\t\t:$" + new DecimalFormat("0.00").format(getTotalBill())
				+ "\nHST\t\t\t\t\t@\t15%\t:$" + new DecimalFormat("0.00").format(getTotalBill() * 0.15)
				+ "\nFinal Price\t\t\t\t\t\t:$"
				+ new DecimalFormat("0.00").format((getTotalBill() + getTotalBill() * 0.15)));

	}

}