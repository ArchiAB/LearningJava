package assignmetOpps;

import java.util.Scanner;

public class PinCheckPoint {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			int correctPin = 1234;
			int tries = 0;

			System.out.println("Enter your PIN");

			int enteredPin = scanner.nextInt();
			tries++;
			while (enteredPin != correctPin && tries < 3) {
			    System.out.println("\nWrong PIN. Please try again.");
			    System.out.println("Enter your PIN: ");
			    enteredPin = scanner.nextInt();
			    tries++;
			}
			if (enteredPin == correctPin) {
			    System.out.println("\nPIN correct. Welcome.");

			    int numberOfAccounts = 4;
			    BankAccount[] bankAccounts = new BankAccount[numberOfAccounts];

      
			    int pinToSearch = 1234;

			    BankAccount foundAccount = getBankAccountByPin(bankAccounts, pinToSearch);
			    if (foundAccount != null) {
			        System.out.println("Account Number: " + foundAccount.getCIBC());
			    } else {
			        System.out.println("Bank account not found.");
			    }
			} else if (tries >= 3) {
			    System.out.println("\nYou tried many times. Your account is locked.");
			}
		}
    }

    public static BankAccount getBankAccountByPin(BankAccount[] bankAccounts, int pin) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getPin() == pin) {
                return bankAccount;
            }
        }
        System.err.println("Wrong PIN. Try Again.");
        return null;
    }
    
}
