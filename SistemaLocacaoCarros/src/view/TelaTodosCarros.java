package view;

import controller.CarController;
import model.Car;

public class TelaTodosCarros {
	public static void mostrar() {
		CarController carController = new CarController();
		for (Car car : carController.getCars()) {
			System.out.println(car.toString() + "\n");
		}
	}
}
