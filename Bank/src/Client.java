import java.util.ArrayList;
import java.util.List;

public class Client extends Account {
	List<Account> accounts = new ArrayList<Account>();

	public List<Account> getAccounts() {
		return accounts;
	}

	void addAccount(Account x) {
		accounts.add(x);
	}

}
