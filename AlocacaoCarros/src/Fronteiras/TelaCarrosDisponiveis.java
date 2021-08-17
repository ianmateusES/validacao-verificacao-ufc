package Fronteiras;

import Controller.CarController;
import Model.Car;

public class TelaCarrosDisponiveis {
	public static void mostrar() {
		for (Car car : CarController.getInstance().availableCars()) {
			System.out.println(car);
		}
	}
}
