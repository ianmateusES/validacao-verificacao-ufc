package view;

import java.util.Scanner;

import controller.ClientController;

public class TelaEditarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o CPF do Cliente a ser editado");
		String cpf = input.nextLine();
		
		System.out.println("Digite o novo nome:");
		String name = input.nextLine(); 
		
		System.out.println("Digite o novo endereço");
		String address = input.nextLine();
		
		ClientController clientController = new ClientController();
		if(clientController.updateClient(cpf, name, address)) {
			System.out.println("Cliente editado com sucesso");
		} else {
			System.out.println("erro ao editar cliente");
		}
	}
}
