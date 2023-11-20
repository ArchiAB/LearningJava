package loopsAssignmentThree;

import java.util.Scanner;

public class UserNameAndPassword {
    private static final String saved_UserName = "pivotAdmin";
    private static final String Saved_UserPassword = "Admin123";
    private static final int Maximum_TimeAttempts = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts < Maximum_TimeAttempts) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (isValidCredentials(enteredUsername, enteredPassword)) {
                System.out.println("You are logged in to the application.");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect User ID or password. Try again.");
            }
        }

        if (attempts == Maximum_TimeAttempts) {
            System.out.println("Account locked.");
        }

        scanner.close();
    }

    private static boolean isValidCredentials(String username, String password) {
        return username.equals(saved_UserName) && password.equals(Saved_UserPassword);
    }
}