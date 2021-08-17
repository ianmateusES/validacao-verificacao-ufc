package view;

import controller.ClientController;
import model.Client;

public class TelaMostrarClientes {
	public static void mostrar() {
		ClientController clientController = new ClientController();
		for (Client client : clientController.listClients()) {
			System.out.println(client.toString() + "\n");
		}
	}
}
