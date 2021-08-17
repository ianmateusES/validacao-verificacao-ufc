package view;

import java.util.Scanner;

import controller.RentalController;

public class TelaAlugarCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o cpf do cliente:\n");
		String cpf = input.nextLine();
		
		System.out.println("Digite a placa do carro deseja alugar:\n");
		String license_plate = input.nextLine();
		
		RentalController rentalController = new RentalController();
		if(rentalController.addRental(cpf, license_plate)) {
			System.out.println("Carro alugado com sucesso");
		} else {
			System.out.println("Erro ao alugar carro");
		}
	}
}
