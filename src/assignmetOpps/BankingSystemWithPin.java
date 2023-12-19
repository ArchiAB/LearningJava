package assignmetOpps;

import java.util.Scanner;

public class BankingSystemWithPin {
   
	public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("B001122334455667", 8000, "1234");
        BankAccount[] bankAccounts = {bankAccount1};
        try (Scanner scanner = new Scanner(System.in)) {
			Menu.welcome();
			String pin = scanner.nextLine();
			BankAccount currentBankAccount = BankingSystemWithPin.getBankAccountByPin(bankAccounts, pin);
			ATM.useATM(currentBankAccount);
		}
    }
        public static BankAccount getBankAccountByPin(BankAccount[] bankAccounts, String pin) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.pin.equals(pin)) {
                return bankAccount;
                
            } else if (!bankAccount.pin.equals(pin) ) {
                System.out.println("You entered wrong PIN. Please try again.");
                
            }
        }
        return null;
    }
}