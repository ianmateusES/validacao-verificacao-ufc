package Fronteiras;

import java.util.Scanner;

import Controller.ClientController;

public class TelaBuscarCliente {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o CPF do Cliente");
		String cpf = input.nextLine();
		if(ClientController.getInstance().searchClient(cpf) == null) {
			System.out.println("Cliente não existe");
		}else {
			System.out.println(ClientController.getInstance().searchClient(cpf));
		}
	}
}
