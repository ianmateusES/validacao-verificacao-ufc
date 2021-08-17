package view;

import java.util.Scanner;

import controller.ClientController;

public class TelaRemoverCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o CPF do Cliente a ser removido");
		String cpf = input.nextLine();
		
		ClientController clientController = new ClientController();
		if(clientController.removeClient(cpf)) {
			System.out.println("Cliente removido com sucesso!");
		} else {
			System.out.println("erro ao remover cliente!");
		}
	}
}
