package Fronteiras;

import java.util.Scanner;

import Controller.CarController;

public class TelaBuscarCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro que voc� deseja buscar: ");
		String license_plate = input.nextLine();
		
		if(CarController.getInstance().searchCar(license_plate) == null) {
			System.out.println("Carro n�o encontrado");
		}else {
			System.out.println(CarController.getInstance().searchCar(license_plate));
		}
	}
}
