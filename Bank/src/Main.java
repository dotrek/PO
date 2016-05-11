import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating method
		Bank bank = new Bank();
		Firm firm = new Firm();
		BigFirm bigFirm = new BigFirm();
		Person person = new Person();
		ImportantPerson vip = new ImportantPerson();
		for (int i = 0; i < 1 + Math.random() * 2; i++)
			firm.accounts.add(new Account());
		for (int i = 0; i < 1 + Math.random() * 2; i++)
			bigFirm.accounts.add(new Account());
		for (int i = 0; i < 1 + Math.random() * 2; i++)
			person.accounts.add(new Account());
		for (int i = 0; i < 1 + Math.random() * 2; i++)
			vip.accounts.add(new Account());
		bank.addClient(firm);
		bank.addClient(bigFirm);
		bank.addClient(person);
		bank.addClient(vip);
		double sumNormal = 0d;
		double sumAll = 0d;
		double sumFirm = 0d;
		double sumVIP = 0d;
		for (Client cl : bank.getClients()) {
			if (cl instanceof Person || cl instanceof ImportantPerson)
				sumAll += cl.getBalance();
			if (cl instanceof Person)
				sumNormal += cl.getBalance();
			if (cl instanceof Firm)
				sumFirm += cl.getBalance();
			if (cl instanceof ImportantPerson || cl instanceof BigFirm)
				sumVIP += cl.getBalance();

		}
		while (true) {
			System.out.println("1. Persons: Normal");
			System.out.println("2. Persons: Normal + Important");
			System.out.println("3. Firms: Normal");
			System.out.println("4. Firms: Big + Persons: Important");
			int x = scan.nextInt();
			switch (x) {
			case 1:

				System.out.println(sumNormal);
				break;
			case 2:
				System.out.println(sumAll);
				break;
			case 3:
				System.out.println(sumFirm);
				break;
			case 4:
				System.out.println(sumVIP);
				break;
			default:
				System.out.println("Bad try ;)");
				break;
			}
		}
	}
}
