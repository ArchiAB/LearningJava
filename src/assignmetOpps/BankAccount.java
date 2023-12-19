package assignmetOpps;

public class BankAccount {
    private String CIBC;
    int balance;
    public String pin;

    
    public BankAccount(String CIBC, int balance, String pin) {
        this.setCIBC(CIBC);
        this.balance = balance;
        this.pin = pin;
    }

    public void BankAccount1(String cIBC2, int balance2, String pin2) {
		
	} 

	public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
            System.out.println("You withdrew " + amount);
        } else {
            System.out.println("Not enough money. ");
        }
    } 

	public String getCIBC() {
		return CIBC;
		
	}

	public void setCIBC(String cIBC) {
		CIBC = cIBC;
	}

	public String getCIBC1() {
	
		return null;
	}

	public int getPin() {
		
		return 0;
	}
} 