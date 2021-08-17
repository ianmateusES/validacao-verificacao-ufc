package controller;

import java.time.Year;
import java.util.List;

import connection.Conexao;
import dao.CarDAO;
import model.Car;

public class CarController {
	private CarDAO carDAO;
	
	public CarController() {
		this.carDAO = new CarDAO(Conexao.getInstance().getConnection());
	}
	
	public CarController(CarDAO carDAO) {
		this.carDAO = carDAO;
	}
	
	public boolean addCar(String model, String license_plate, String color, int year, float fine_amountl) {
		if(model ==  null || model.trim().equals(""))  return false;
		if(!(model.matches("[A-Z a-z]*"))) return false;
		if(license_plate ==  null || license_plate.trim().length() < 7) return false;
		if(!(license_plate.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}"))) return false;
		if(color ==  null || color.trim().equals("")) return false;
		if(!(color.matches("[A-Z a-z]*"))) return false;
		if(year > Year.now().getValue() || year < Year.now().getValue() - 30) return false;
		if(fine_amountl <= 0) return false;
		
		Car car = new Car(model, license_plate, color, year, fine_amountl);

		return this.carDAO.create(car);
	}
	
	public List<Car> getCars() {
		return this.carDAO.list();
	}
	
	public boolean removeCar(String license_plate) {
		if(license_plate ==  null || license_plate.trim().equals("") || !(license_plate.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}"))) return false;
		
		return this.carDAO.delete(license_plate);
	}
	
	public boolean updateFine_amount(String license_plate, float fine_amount) {
		if(license_plate ==  null || license_plate.trim().equals("") || !(license_plate.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}"))) return false;
		if(fine_amount <= 0) return false;
		 
		return this.carDAO.update_fine_amount(license_plate, fine_amount);
	}
	
	public List<Car> availableCars(){
		return this.carDAO.list_available(true);
	}
	
	public Car searchCar(String license_plate) {
		if(license_plate ==  null || license_plate.trim().equals("") || !(license_plate.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}"))) return null;
		
		Car car = this.carDAO.search_license_plate(license_plate);
		if(car.getLicense_plate() == null) return null;
		
		return car;
	}

//	public boolean rentCar(String placa) {
//		for (Car car : CarRepository.getInstance().availableCars()) {
//			if(car.getLicense_plate().equals(placa)) {
//				car.setRent(true);
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean returnCar(String placa) {
//		for (Car car : CarRepository.getInstance().getCars()) {
//			if(car.getLicense_plate().equals(placa)) {
//				if(car.isRent()) {
//					car.setRent(false);
//					return true;
//				}
//			}
//		}
//		return false;
//	}
}
