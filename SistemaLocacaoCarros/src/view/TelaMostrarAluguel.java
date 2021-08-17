package view;

import java.util.Scanner;

import controller.RentalController;
import model.Rental;

public class TelaMostrarAluguel {
	public static void mostrar() {
		RentalController rentalController = new RentalController();
		for (Rental rental : rentalController.listRental()) {
			System.out.println(rental.toString() + "\n");
		}
	}
}
