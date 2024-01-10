package cruiseAndHotelAssignment;

import java.util.Scanner;

public class UsersDetails {
	private String name;
	private String phoneNO;
	private String userName;
	private String emailId;
	private String password;

	public String getEmailId(Scanner sc) {
		System.out.println("Please enter your email address -");
		emailId = sc.nextLine();
		while (!(emailId.contains("@")) || !(emailId.contains(".")) || emailId.endsWith(".")) {

			System.out.println("Please enter a valid email address.");
			emailId = sc.nextLine();
		}
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName(Scanner sc) {
		System.out.println("Enter your username -");
		userName = sc.nextLine();
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword(Scanner sc) {
		System.out.println(
				"Please enter your password. The password should have 8 characters and must have one or more of special characters from the following: \n ex: - !,@,#,$,%,^,& or *.");
		password = sc.nextLine();
		while (password.length() < 8 || !(password.contains("!")) && !(password.contains("@"))
				&& !(password.contains("#")) && !(password.contains("$")) && !(password.contains("%"))
				&& !(password.contains("^")) && !(password.contains("&")) && !(password.contains("*"))) {
			System.out.println(
					"Password not created. Please create a password which has more than 8 characters and must have one or more of special characters ex: !,@,#,$,%,^,& or *.");
			password = sc.nextLine();
		}
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName(Scanner sc) {
		System.out.println("Please enter your Name :");
		name = sc.nextLine();
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo(Scanner sc) {
		System.out.println("Enter your Phone Number :");
		phoneNO = sc.nextLine();

		while (phoneNO.length() != 10 || !phoneNO.matches("\\d+")) {
			System.out.println(
					"Please enter a valid ten '10' digits 'Phone Numbers' without any gaps or any other characters.");
			phoneNO = sc.nextLine();
		}

		return phoneNO;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNO = phoneNo;
	}

	public void registerUser(Scanner sc) {
		setEmailId(getEmailId(sc));
		setUserName(getUserName(sc));
		setPassword(getPassword(sc));
		setName(getName(sc));
		setPhoneNo(getPhoneNo(sc));
		System.out.println("Thank you for registering with Hotel & Cruise ");

	}

	public boolean isPassWordValidated(Scanner sc) {

		System.out.println(
				"Do you want to change any of your personal information ? Press 'Y' for 'Yes'. Press any other alphabet to exit.");
		String changeInfo = sc.nextLine().trim();
		if (changeInfo.equalsIgnoreCase("Y")) {
			System.out.println("To change your your personal information, first enter your current password.");
			String passwordByUser = sc.nextLine();
			for (int i = 0; i < 3; i++) {
				if (passwordByUser.equals(this.password)) {
					System.out.println("Password validated successfully.");
					break;
				} else if (i < 2) {

					System.out.println("Password incorrect. Please try again. Enter your password below.");
					passwordByUser = sc.nextLine();
					;
				}

				else {
					System.out.println(
							"There are 3 unsuccessful attempts made to validate password./n Please contact for support");
					;
				}
			}

			if (passwordByUser.equals(this.password)) {
				return true;
			} else {
				System.out.println("Thank you for using our service!");
				return false;
			}
		}

		else {
			System.out.println("Thank you for using our service!");
			return false;
		}

	}

	public void changeInfo(boolean isPasswordValidated, Scanner sc) {
		if (isPasswordValidated) {
			String anyMoreChange = "";
			do {
				System.out.println(
						"Please enter a, b, c, d or e for the information you want to change. \n a - Name \n b - Password \n c - Email \n d - Phone Number \n e - Username");
				String infoToBeChanged = sc.nextLine().trim();

				if (infoToBeChanged.equals("a")) {
					setName(getName(sc));
					System.out.println("Your Name changed successfully.");
				}

				else if (infoToBeChanged.equals("b")) {
					setPassword(getPassword(sc));
					System.out.println("Password changed successfully.");
				}

				else if (infoToBeChanged.equals("c")) {
					setEmailId(getEmailId(sc));
					System.out.println("Email address changed successfully.");
				}

				else if (infoToBeChanged.equals("d")) {
					setPhoneNo(getPhoneNo(sc));
					System.out.println("Phone number changed successfully.");
				}

				else if (infoToBeChanged.equals("e")) {
					setUserName(getUserName(sc));
					System.out.println("User name changed successfully.");

				} else {
					System.out.println("Invalid Input. This operation can not be performed.");
				}
				System.out.println(
						"Do you wish to change any other personal information? Please enter Y for Yes or enter any other input to exit.");
				anyMoreChange = sc.nextLine().trim();
			} while (anyMoreChange.equalsIgnoreCase("Y"));

			System.out.println("Thank you for using our service!");
		}
	}

	public void logIn(Scanner sc) {
		System.out.println("Please log in now using your username and password.\nPlease enter your username.");
		String userName = sc.nextLine();
		System.out.println("\nPlease enter password.");
		String password = sc.nextLine();
		while (!(userName.equals(this.userName)) || !(password.equals(this.password))) {
			System.out.println("Incorrect details entered. "
					+ "\nIf you do not remember your user details, please enter your email address below, on which we will send your user details. "
					+ "\nOnce you log in with your details that we emailed you, Our recommendation will be to change your username and password."
					+ "\nIf you remember your user details, please enter any alphabet and press 'Enter'");
			String emailIdForDetails = sc.nextLine();
			if (emailIdForDetails.equals(this.emailId)) {
				System.out.println("User details emailed. Please check your email and try again.");
			}

			System.out.println("Please enter your username.");
			userName = sc.nextLine();
			System.out.println("Please enter your password.");
			password = sc.nextLine();
		}

		if (userName.equals(this.userName) && password.equals(this.password)) {
			System.out.println("Login Successful!");
		}
	}
}