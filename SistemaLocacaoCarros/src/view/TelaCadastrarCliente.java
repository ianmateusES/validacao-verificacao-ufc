package view;

import java.util.Scanner;

import controller.ClientController;

public class TelaCadastrarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite seu nome:");
		String name = input.nextLine(); 
		
		System.out.println("Digite seu endereço:");
		String address = input.nextLine();
		
		System.out.println("Digite seu CPF: ");
		String cpf = input.nextLine();
		
		System.out.println("Digite seu telefone pra contato:");
		String contact = input.nextLine();
		

		ClientController clientController = new ClientController();
		if(clientController.addClient(name, address, contact, cpf)) {
			System.out.println("Usuario Cadastrado com sucesso!");
		}else {
			System.out.println("Erro ao adicionar usuario");
		}
	}
}
