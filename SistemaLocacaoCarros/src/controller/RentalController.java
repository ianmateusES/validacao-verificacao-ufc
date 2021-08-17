package controller;

import java.util.List;

import connection.Conexao;
import dao.CarDAO;
import dao.ClientDAO;
import dao.RentalDAO;
import model.Car;
import model.Client;
import model.Rental;

public class RentalController {
	private static RentalController controller = null;
	private RentalDAO rentalDAO;
	private ClientDAO clientDAO;
	private CarDAO carDAO;
	
	public RentalController() {
		this.rentalDAO = new RentalDAO(Conexao.getInstance().getConnection());
		this.clientDAO = new ClientDAO(Conexao.getInstance().getConnection());
		this.carDAO = new CarDAO(Conexao.getInstance().getConnection());
	}
	
	public RentalController(RentalDAO rentalDAO, ClientDAO clientDAO, CarDAO carDAO) {
		this.rentalDAO = rentalDAO;
		this.clientDAO = clientDAO;
		this.carDAO = carDAO;
	}
	
	public boolean addRental(String cpf, String license_plate) {
		if(cpf == null || cpf.trim().length() != 11) return false;
		if(license_plate ==  null || license_plate.trim().length() < 7) return false;
		if(!(license_plate.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}"))) return false;
		
		Client client = this.clientDAO.search_cpf(cpf);
		if(client.getId() == 0) {
			return false;
		}
		
		Car car = this.carDAO.search_license_plate(license_plate);
		if(car.getId() == 0 || !car.isAvailable()) {
			return false;
		}
		
		Rental rental = new Rental(client.getCpf(), car.getLicense_plate());
		
		return this.rentalDAO.create(rental);
	}
	
	public List<Rental> listRental() {
		return this.rentalDAO.list();
	}
	
	public List<Rental> listAvailableRental() {
		return this.rentalDAO.search_rented(true);
	}
	
	public List<Rental> listClintRental(String cpf) {
		if(cpf == null || cpf.trim().length() != 11) return null;
		
		Client client = this.clientDAO.search_cpf(cpf);
		if(client.getId() == 0) {
			return null;
		}
		
		return this.rentalDAO.search_client_rented(client.getCpf(), true);
	}
	
	public boolean carReturn(String license_plate) {
		if(license_plate ==  null || license_plate.trim().length() < 7) return false;
		if(!(license_plate.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}"))) return false;
		
		Car car = this.carDAO.search_license_plate(license_plate);
		if(car.getId() == 0 || car.isAvailable()) {
			return false;
		}
		
		Rental rental = this.rentalDAO.search_license_plate_rented(license_plate);
		if(rental.getId() == 0) {
			return false;
		}
		
		this.carDAO.update_available(license_plate, true);
		
		return this.rentalDAO.update_rented(rental.getId(), false);
		
	}
}
