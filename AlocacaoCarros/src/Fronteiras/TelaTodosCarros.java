package Fronteiras;

import Controller.CarController;
import Model.Car;

public class TelaTodosCarros {
	public static void mostrar() {
		for (Car car : CarController.getInstance().getCars()) {
			System.out.println(car);
		}
	}
}
