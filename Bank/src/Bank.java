import java.util.ArrayList;
import java.util.List;

public class Bank extends Client {
	List<Client> clients = new ArrayList<Client>();

	void addClient(Client c) {
		clients.add(c);
	}

	public List<Client> getClients() {
		return clients;
	}
}
