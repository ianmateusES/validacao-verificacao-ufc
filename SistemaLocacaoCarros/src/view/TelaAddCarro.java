package view;

import java.util.Scanner;

import controller.CarController;

public class TelaAddCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o modelo do carro:");
		String model = input.nextLine();
		
		System.out.println("Digite a placa do carro:");
		String license_plate = input.nextLine();
		
		System.out.println("Digite a cor do carro:");
		String color =  input.nextLine();
		
		System.out.println("Digite o ano do carro:");
		int year = input.nextInt();
		
		System.out.println("Digite o preço de Aluguel do carro:");
		float fine_amountl = input.nextFloat();
		
		CarController carController = new CarController();
		if(carController.addCar(model, license_plate, color, year, fine_amountl)) {
			System.out.println("carro adicionado com sucesso");
		} else {
			System.out.println("erro ao adicionar carro");
		}
		
		input.close();
	}

}
