package cruiseAssignment;

import java.util.Scanner;

public class UserInformations {

	Scanner sc = new Scanner(System.in);

	private String name;
	private String userName;
	private String phoneNumber;
	private String emailId;
	private String passWord;

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPhoneNumber(String phoneNumber) {
		while (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
			System.out.println("Please enter a valid 10 digit phone number without any spaces or any other character.");
			phoneNumber = sc.next();
		}
		this.phoneNumber = phoneNumber;
	}

	public void setEmailId(String emailId) {
		while (!(emailId.contains("@")) || !(emailId.contains(".")) || emailId.endsWith(".")) {
			System.out.println("Please enter valid email address.");
			emailId = sc.next();
		}
		this.emailId = emailId;
	}

	public void setPassWord(String passWord) {
		while (passWord.length() < 8 || !(passWord.contains("!")) && !(passWord.contains("@"))
				&& !(passWord.contains("#")) && !(passWord.contains("$")) && !(passWord.contains("%"))
				&& !(passWord.contains("^")) && !(passWord.contains("&")) && !(passWord.contains("*"))) {
			System.out.println(
					"Password not created. Please create a password which is 8 or more characters with atleast one special character from !,@,#,$,%,^,& or *.");
			passWord = sc.next();
		}
		this.passWord = passWord;
	}

	public void logIn(String logInUserName, String logInPassword) {
		while (!(logInUserName.equals(getUserName())) || !(logInPassword.equals(getPassWord()))) {
			System.out.println("Incorrect details entered. "
					+ "\nIf you do not remember your user details, please enter your email address below, we will email you your user details. "
					+ "\nOnce you log in with your informations that we email to you, we recommend changing your user name and the password."
					+ "\nIf you remember your user details, please enter any alphabet and press enter");
			String emailIdToRecoverUserDetails = sc.next();
			if (emailIdToRecoverUserDetails.equals(getEmailId())) {
				System.out.println("User details Emailed. Please check your Email and try again.");
			}

			System.out.println("Please enter the username.");
			sc.nextLine();
			logInUserName = sc.nextLine();
			System.out.println("Please enter the password.");
			logInPassword = sc.next();
		}

		if (logInUserName.equals(getUserName()) && logInPassword.equals(getPassWord())) {
			System.out.println("Login Successful!");
		}
	}

	public boolean isPassWordValidated(String passwordToCheck) {
		for (int i = 0; i < 3; i++) {
			if (passwordToCheck.equals(getPassWord())) {
				System.out.println("Password validated successfully.");
				break;

			} else if (i < 2) {
				System.out.println("Password incorrect. Please try again.Enter your password below.");
				passwordToCheck = sc.next();
				;
			}

			else {
				System.out.println(
						"There are 3 unsuccessful attempts to validate password and hence we can not change any personal details at this time.");
				;

			}
		}
		if (passwordToCheck.equals(getPassWord())) {
			return true;
		} else {
			return false;
		}

	}
}