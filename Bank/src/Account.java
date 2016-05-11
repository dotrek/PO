import java.util.UUID;

public class Account {

	String accNumber;
	double accBalance;

	Account() {
		accNumber = new String();
		accNumber = UUID.randomUUID().toString();
		accBalance = 1d + Math.random() * 100;
	}

	double getBalance() {
		return accBalance;
	}

	String getNumber() {
		return accNumber;
	}

	void deposit(double amount) {
		accBalance += amount;
	}

	void withdraw(double amount) {
		if (accBalance - amount >= 0d)
			accBalance -= amount;
		else
			System.out.println("too high amount");
	}
}
