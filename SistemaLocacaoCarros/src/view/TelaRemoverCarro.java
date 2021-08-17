package view;

import java.util.Scanner;

import controller.CarController;

public class TelaRemoverCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro:\n");
		String license_plate = input.nextLine();
		
		CarController carController = new CarController();
		if(carController.removeCar(license_plate)) {
			System.out.println("Carro removido com sucesso");
		}else {
			System.out.println("Erro ao remover carro");
		}
	}
}
