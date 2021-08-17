package controller;

import java.util.List;

import connection.Conexao;
import dao.ClientDAO;
import model.Client;


public class ClientController {
	private ClientDAO clientDAO;
	
	public ClientController() {
		this.clientDAO = new ClientDAO(Conexao.getInstance().getConnection());
	}
	
	public ClientController(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	public boolean addClient(String name, String address, String contact, String cpf) {
		if(name == null || name.trim().equals("")) return false;
		if(address == null || address.trim().equals("")) return false;
		if(cpf == null || cpf.trim().length() != 11) return false;
		if(contact == null || contact.trim().length() < 8) return false;
		if(!(name.matches("[A-Z a-z]*"))) return false;

		Client client = new Client(name, address, contact, cpf);
		
		return this.clientDAO.create(client);
	}
	
	public List<Client> listClients(){
		return this.clientDAO.list();
	}
	
	public boolean removeClient(String cpf) {
		if(cpf == null) return false;
		if(cpf.length() != 11) return false;
		 
		return this.clientDAO.delete(cpf);
	}
	
	public boolean updateClient(String cpf, String name, String address) {
		if(cpf == null || cpf.trim().length() != 11) return false;
		if(name == null || name.trim().equals("")) return false;
		if(address == null || address.trim().equals("")) return false;
		if(!(name.matches("[A-Z a-z]*"))) return false;
 
		return this.clientDAO.update(cpf, name, address);
	}
	
	public Client searchClient(String cpf) {
		if(cpf == null || cpf.trim().length() != 11) return null;
		
		Client client = this.clientDAO.search_cpf(cpf);
//		System.out.println(client);
		if (client.getId() == 0) return null;
		
		return client;
	}
}
