package view;

import controller.CarController;
import model.Car;

public class TelaCarrosDisponiveis {
	public static void mostrar() {
		CarController carController = new CarController();
		for (Car car : carController.availableCars()) {
			System.out.println(car.toString() + "\n");
		}
	}
}
