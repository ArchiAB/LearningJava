package cruiseAndHotelAssignment;

import java.util.Scanner;

public class BookingsMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UsersDetails guest = new UsersDetails();
		MyBookings booking = null;
		boolean isExtraBooking = true;
		System.out.println("Welcome, Guest! Please sign up to book a service.");
		guest.registerUser(sc);
		while (isExtraBooking) {
			boolean isService = false;
			while (!(isService)) {
				System.out.println(
						"Which is the service you want to book: \nPlease enter (1) for Hotel and (2) for Cruise.");
				String service = sc.nextLine();

				if (service.equalsIgnoreCase("1")) {//case 1 is for Hotel 
					isService = true;
					System.out.println("Please enter the room you want to select -"
							+ "\nDeluxe Suite: accommodates 2 adults and 2 children at the rate "
							+ "of $180/ night\nFamily Suite: accommodates 4 adults and" + " 4 children at $230/ night");
					String hotelSelected = sc.nextLine();
					while (!hotelSelected.equalsIgnoreCase("Deluxe Suite")
							&& !hotelSelected.equalsIgnoreCase("Family Suite")) {
						System.out.println("Please enter an option only from Deluxe Suite or Family Suite availabe.");
						hotelSelected = sc.nextLine();
					}

					booking = hotelSelected.equalsIgnoreCase("Deluxe Suite") ? new DeluxeSuite()
							: hotelSelected.equalsIgnoreCase("Family Suite") ? new FamilySuite() : new HotelBookings();
				}

				else if (service.equalsIgnoreCase("2")) {//case 2 is Cruise
					isService = true;
					boolean isSelectionConfirmed = false;
					while (!isSelectionConfirmed) {
						System.out.println(
								"We offer 4 different packages as displayed below. Please enter the cruise that you want to select.- "
								+ "\nScenic Cruise \nSunset Cruise \nDiscovery Cruise \nMystery Cruise");
						String cruiseSelected = sc.nextLine();

						while (!cruiseSelected.equalsIgnoreCase("Scenic Cruise")
								&& !cruiseSelected.equalsIgnoreCase("Sunset Cruise")
								&& !cruiseSelected.equalsIgnoreCase("Discovery Cruise")
								&& !cruiseSelected.equalsIgnoreCase("Mystery Cruise")) {
							System.out.println("Please enter an option only from the 4 different packages availabe.");
							cruiseSelected = sc.nextLine();
						}
						booking = cruiseSelected.equalsIgnoreCase("Scenic Cruise") ? new ScenicCruise()
								: cruiseSelected.equalsIgnoreCase("Mystery Cruise") ? new MysteryCruise()
										: cruiseSelected.equalsIgnoreCase("Sunset Cruise") ? new SunsetCruise()
												: cruiseSelected.equalsIgnoreCase("Discovery Cruise")
														? new DiscoveryCruise()
														: new CruiseBookings();
						booking.displaySelectedDetails();
						String selectionConfirmation = sc.nextLine().trim();
						if (selectionConfirmation.equalsIgnoreCase("Y")) {
							isSelectionConfirmed = true;
						}
					}
				}
			}
			booking.calculateTotalPrice(sc);
			booking.displayCalculatedPrice();
			System.out.println(
					"Do you want to book another Hotel Room or Cruise. Please enter 'Y' for Yes or any other input for 'No' ");
			String extraBooking = sc.nextLine().trim();
			if (!(extraBooking.equalsIgnoreCase("Y"))) {
				isExtraBooking = false;
			}
		}
		guest.changeInfo(guest.isPassWordValidated(sc), sc);
	}

}
