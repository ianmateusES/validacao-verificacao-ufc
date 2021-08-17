package Fronteiras;

import java.util.Scanner;

import Controller.ClientController;

public class TelaAlugarCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro que você deseja alugar:\n");
		String license_plate = input.nextLine();
		
		if(ClientController.getInstance().rentCar(license_plate)) {
			System.out.println("Carro alugado com sucesso");
		}else {
			System.out.println("erro ao alugar carro");
		}
	}
}
