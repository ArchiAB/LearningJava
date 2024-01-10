package cruiseAndHotelAssignment;

import java.util.Scanner;

public class DeluxeSuite extends HotelBookings {
	Scanner sc = new Scanner(System.in);

	public DeluxeSuite() {
		super.booking = getBooking();
		super.dailyPrice = getDailyPrice();
		super.adultMealPrice = getAdultMealPrice();
		super.kidsMealPrice = getKidMealPrice();
		super.noOfAdults = getNoOfAdults();
		super.noOfKids = getNoOfKids();
		super.noOfRooms = getNoOfRooms();
		super.noOfDays = getNoOfDays();
	}

	public String getBooking() {
		booking = "Deluxe Hotel";
		return booking;
	}

	public int getNoOfDays() {
		System.out.println("Please enter the number of days of stay.");
		noOfDays = Integer.parseInt(sc.nextLine().trim());
		return noOfDays;
	}

	public double getDailyPrice() {
		dailyPrice = 180;
		return dailyPrice;
	}

	public double getAdultMealPrice() {
		adultMealPrice = 25;
		return adultMealPrice;
	}

	public double getKidMealPrice() {
		kidsMealPrice = 5;
		return kidsMealPrice;
	}

	public int getNoOfAdults() {
		System.out.println("Please enter number of adults.");
		noOfAdults = Integer.parseInt(sc.nextLine().trim());
		while (noOfAdults == 0) {
			System.out.println("Please enter atleast 1 adult to proceed.");
			noOfAdults = Integer.parseInt(sc.nextLine().trim());
		}

		return noOfAdults;
	}

	public int getNoOfKids() {
		System.out.println("Please enter number of kids.");
		noOfKids = Integer.parseInt(sc.nextLine().trim());
		return noOfKids;
	}

	public int getNoOfRooms() {
		int roomCapacity = 2;
		int roomsNeededAdult = 0;
		int roomsNeededKid = 0;
		int roomsNeeded = 0;
		int capacityCheckAdult = 0;
		int capacityCheckKid = 0;

		for (int i = 1; i < roomCapacity; i++) {
			capacityCheckAdult = noOfAdults++;
			if (capacityCheckAdult % roomCapacity == 0) {
				roomsNeededAdult = capacityCheckAdult / roomCapacity;
			}
		}

		for (int i = 1; i < roomCapacity; i++) {
			capacityCheckKid = noOfKids++;
			if (capacityCheckKid % roomCapacity == 0) {
				roomsNeededKid = capacityCheckKid / roomCapacity;
			}
		}
		if (roomsNeededAdult > roomsNeededKid) {
			roomsNeeded = roomsNeededAdult;
		} else {
			roomsNeeded = roomsNeededKid;
		}

		System.out.println("Please enter the number of rooms you want to book.");
		noOfRooms = Integer.parseInt(sc.nextLine().trim());

		while (roomsNeeded > noOfRooms) {
			System.out.println(
					"Number of rooms provided by you can not accomodate all the guests. You need to book atleast "
							+ roomsNeeded + " rooms. Please enter correct number of rooms again.");
			noOfRooms = Integer.parseInt(sc.nextLine().trim());
		}
		return noOfRooms;
	}

}
