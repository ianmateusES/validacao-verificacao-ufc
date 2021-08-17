package Fronteiras;

import Controller.ClientController;
import Model.Client;

public class TelaMostrarClientes {
	public static void mostrar() {
		for (Client client : ClientController.getInstance().listClients()) {
			System.out.println(client + "\n");
		}
	}
}
