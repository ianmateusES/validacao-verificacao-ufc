package view;

import java.util.Scanner;

import controller.RentalController;

public class TelaDevolverCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro que você deseja devolver:\n");
		String license_plate = input.nextLine();
		
		RentalController rentalController = new RentalController();
		if(rentalController.carReturn(license_plate)) {
			System.out.println("Carro devolvido com sucesso");
		}else {
			System.out.println("Erro ao devolver carro");
		}
	}
}
