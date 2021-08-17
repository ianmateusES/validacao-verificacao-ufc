package Repositories;

import java.util.ArrayList;
import java.util.List;

import Model.Client;

public class ClientRepository {
	private static ClientRepository repository;
	private List<Client> clients;
	
	private ClientRepository() {
		clients = new ArrayList<Client>();
	}
	
	public static ClientRepository getInstance() {
		if(repository == null) {
			repository = new ClientRepository();
		}
		return repository;
	}
	
	
	public boolean addClient(Client newClient) {
		for (Client client : clients) {
			if(newClient.getCpf().equals(client.getCpf())) {
				return false;
			}
		}
		clients.add(newClient);
		return true;
	}
	
	public boolean removeClient(String cpf) {
		for (Client client : clients) {
			if(client.getCpf().equals(cpf)) {
				clients.remove(client);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateClient(String cpf , String newAddress) {
		for (Client client : clients) {
			if(client.getCpf().equals(cpf)) {
				client.setAddress(newAddress);
				return true;
			}
		}
		return false;
	}
	
	public Client searchClient(String cpf) {
		for (Client client : clients) {
			if(client.getCpf().equals(cpf)) {
				return client;
			}
		}
		return null;
	}
	
	public List<Client> getClients() {
		return clients;
	}
}
