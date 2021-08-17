package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import model.Rental;

class RentalTest {
	private Rental rentalTest;
	
	private String client_cpf;
	private String car_license_plate;
	private Date date_rental;
	private boolean rented;
	
	@BeforeEach
	void setUp() {
		rentalTest = new Rental();
	}
	
	@AfterEach
	void tearDown() {
		rentalTest = null;
	}
	

	@Test
	@DisplayName("Definir e retornar o cpf do cliente do aluguel")
	@Order(1)
	void testRentalSetGetClient_cpf() {
		String client_cpf = "610.368.443-90";
		rentalTest.setClient_cpf(client_cpf);
		assertEquals(client_cpf, rentalTest.getClient_cpf());
	}
	
	@Test
	@DisplayName("Definir e retornar o placa do carro do aluguel")
	@Order(2)
	void testRentalSetGetLicense_plate() {
		String license_plate = "AAA0A00";
		rentalTest.setCar_license_plate(license_plate);
		assertEquals(license_plate, rentalTest.getCar_license_plate());
	}
	
	@Test
	@DisplayName("Definir e retornar a data de aluguel")
	@Order(3)
	void testRentalSetGetDate_rental() {
		Date date = new Date();
		rentalTest.setDate_rental(date);
		assertEquals(date, rentalTest.getDate_rental());
	}
	
	@Test
	@DisplayName("Definir e retornar a status do aluguel")
	@Order(4)
	void testRentalSetGetRented() {
		boolean rented = true;
		rentalTest.setRented(rented);
		assertEquals(rented, rentalTest.isRented());
	}
	
	@Test
	@DisplayName("Printar os dados de aluguel")
	@Order(5)
	void testRentalSetGetToString() {
		int id = 1;
		String client_cpf = "610.368.443-90";
		String license_plate = "AAA0A00";
		Date date_rental = new Date();
		boolean rented = true;
		
		rentalTest.setId(id);
		rentalTest.setClient_cpf(client_cpf);
		rentalTest.setCar_license_plate(license_plate);
		rentalTest.setDate_rental(date_rental);
		rentalTest.setRented(rented);
		
		String result = id + " CPF cliente=" + client_cpf + ", Placa carro=" + license_plate + ", Data aluguel=" + date_rental
				+ ", Vigor=" + rented;
		
		assertEquals(result, rentalTest.toString());
	}
}
