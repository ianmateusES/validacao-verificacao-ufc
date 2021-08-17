package view;

import java.util.Scanner;

import controller.CarController;
import model.Car;

public class TelaBuscarCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a placa do carro que você deseja buscar: ");
		String license_plate = input.nextLine();
		
		CarController carController = new CarController();
		Car car = carController.searchCar(license_plate);
		if(car == null) {
			System.out.println("Carro não encontrado");
		} else {
			System.out.println(car.toString() + "\n");
		}
	}
}
