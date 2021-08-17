package Controller;

import java.util.List;

import Model.Client;
import Repositories.ClientRepository;


public class ClientController {
	private static ClientController controller = null;
	
	private ClientController() {
		
	}
	
	public static ClientController getInstance() {
		if(controller == null) {
			controller = new ClientController();
		}
		return controller;
	}
	
	public boolean addClient(String name, String address, String contact, String cpf) {
		if(name == null || name.trim().equals("")) return false;
		if(address == null || address.trim().equals("")) return false;
		if(cpf == null || cpf.trim().length() != 11) return false;
		if(contact == null || contact.trim().length() < 8) return false;
		if(!(name.matches("[A-Z a-z]*"))) return false;
		if(!(address.matches("^[^\\W_]*\\d+[^\\W_]*$"))) return false;

		Client client = new Client(name, address, contact, cpf);
		if(ClientRepository.getInstance().addClient(client)) {
			return true;
		}
		return false;
	}
	
	public boolean removeClient(String cpf) {
		if(cpf == null) return false;
		if(cpf.length() != 11) return false;
		if(ClientRepository.getInstance().removeClient(cpf)) {
			return true;
		}
		return false;
	}
	
	public boolean updateClient(String cpf, String address) {
		if(cpf == null) return false;
		if(address == null || address.equals("") || address.equals("\n")) return false;
		if(!(address.matches("^[^\\W_]*\\d+[^\\W_]*$"))) return false;
		if(cpf.length() != 11) return false;

		if(ClientRepository.getInstance().updateClient(cpf, address)) {
			return true;
		}
		return false;
	}
	
	public Client searchClient(String cpf) {
		if(cpf == null) return null;
		Client client = ClientRepository.getInstance().searchClient(cpf);
		return client;
	}
	
	public List<Client> listClients(){
		return ClientRepository.getInstance().getClients();
	}
	
	public boolean rentCar(String placa) {
		if(placa == null) return false;
		return CarController.getInstance().rentCar(placa);
	}
	
	public boolean returnCar(String placa) {
		return CarController.getInstance().returnCar(placa);
	}
}
