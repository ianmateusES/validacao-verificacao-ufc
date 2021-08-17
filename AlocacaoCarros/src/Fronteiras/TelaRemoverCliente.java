package Fronteiras;

import java.util.Scanner;

import Controller.ClientController;

public class TelaRemoverCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o CPF do Cliente a ser removido");
		String cpf = input.nextLine();
		
		if(ClientController.getInstance().removeClient(cpf)) {
			System.out.println("Cliente removido com sucesso!");
		}else {
			System.out.println("erro ao remover cliente!");
		}
	}
}
