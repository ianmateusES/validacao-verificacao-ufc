package Repositories;

import java.util.ArrayList;
import java.util.List;

import Model.Car;

public class CarRepository {
	private static CarRepository repository;
	private List<Car> cars;
	
	private CarRepository() {
		cars = new ArrayList<Car>();
	}
	public static CarRepository getInstance() {
		if(repository == null) {
			repository = new CarRepository();
		}
		return repository;
	}
	
	public boolean addCar(Car car) {
		if(searchCar(car.getLicense_plate()) == null ) {
			cars.add(car);
			return true;
		}
		return false;
	}
	
	public boolean removeCar(String placa) {
		if(searchCar(placa) == null) {
			return false;
		}
		cars.remove(searchCar(placa));
		return true;
	}

	public Car searchCar(String placa) {
		for (Car car : cars) {
			if(car.getLicense_plate().equals(placa)) {
				return car;
			}
		}
		return null;
	}
	
	public boolean updateFine_amountlCar(String license_plate, double newFine_amountl) {
		if(searchCar(license_plate) == null) {
			return false;
		}
		searchCar(license_plate).setLicense_plate(license_plate);
		return true;
	}
	
	public List<Car> availableCars(){
		List<Car> availableCar = new ArrayList<Car>();
		for (Car car : cars) {
			if(!car.isRent()) {
				availableCar.add(car);
			}
		}
		return availableCar;
	}
	
	public List<Car> getCars() {
		return cars;
	}
}
