package view;

import java.util.Scanner;

import controller.ClientController;
import model.Client;

public class TelaBuscarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o CPF do Cliente");
		String cpf = input.nextLine();
		
		ClientController clientController = new ClientController();
		Client client = clientController.searchClient(cpf);
		if(client == null) {
			System.out.println("Cliente não existe");
		} else {
			System.out.println(client.toString() + "\n");
		}
	}
}
