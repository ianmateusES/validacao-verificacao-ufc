package Fronteiras;

import java.util.Scanner;

import Controller.CarController;

public class TelaEditarPrecoCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro:\n");
		String license_plate = input.nextLine();
		
		System.out.println("Digite o novo preco do carro");
		int fine_amountl = input.nextInt();
		
		if(CarController.getInstance().updateFine_amountl(license_plate, fine_amountl)) {
			System.out.println("Preco alterado com sucesso");
		}else {
			System.out.println("Erro ao alterar preco");
		}
	}
}
