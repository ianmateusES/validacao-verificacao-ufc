package Controller;

import java.time.Year;
import java.util.List;


import Model.Car;
import Repositories.CarRepository;

public class CarController {
	private static CarController controler;
	
	private CarController() {
		
	}
	
	public static CarController getInstance() {
		if(controler == null ) {
			return new CarController();
		}
		return controler;
	}
	
	public boolean addCar(String model, String license_plate, String color, int year, double fine_amountl) {
		if(model ==  null || model.trim().equals(""))  return false ; 
		if(!(model.matches("[A-Z a-z]*"))) return false;
		if(license_plate ==  null || license_plate.trim().length() < 7)  return false;
		if(!(license_plate.matches("^[^\\W_]*\\d+[^\\W_]*$"))) return false;
		if(color ==  null || color.trim().equals(""))  return false;
		if(!(color.matches("[A-Z a-z]*"))) return false;
		if(year > Year.now().getValue() || year < Year.now().getValue() - 30) return false;
		if(fine_amountl <= 0) return false;
		
		Car car = new Car(model, license_plate, color, year, fine_amountl);
		CarRepository.getInstance().addCar(car);
		return true;
	}
	
	public boolean removeCar(String license_plate) {
		if(license_plate ==  null)  throw new IllegalArgumentException("placa nao pode ser nula");
		if(CarRepository.getInstance().removeCar(license_plate)) {
			return true;
		}
		return false;
	}
	
	public boolean updateFine_amountl(String license_plate, double newFine_amountl) {
		if(newFine_amountl <= 0) return false;
		if(CarRepository.getInstance().updateFine_amountlCar(license_plate, newFine_amountl)){
			return true;
		}
		return false;
	}
	
	public List<Car> availableCars(){
		return CarRepository.getInstance().availableCars();
	}
	
	public boolean rentCar(String placa) {
		for (Car car : CarRepository.getInstance().availableCars()) {
			if(car.getLicense_plate().equals(placa)) {
				car.setRent(true);
				return true;
			}
		}
		return false;
	}
	
	public boolean returnCar(String placa) {
		for (Car car : CarRepository.getInstance().getCars()) {
			if(car.getLicense_plate().equals(placa)) {
				if(car.isRent()) {
					car.setRent(false);
					return true;
				}
			}
		}
		return false;
	}
	
	public Car searchCar(String placa) {
		return CarRepository.getInstance().searchCar(placa);
	}
	
	public List<Car> getCars(){
		return CarRepository.getInstance().getCars();
	}
	
}
