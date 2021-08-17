package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Model.Car;

@TestMethodOrder(OrderAnnotation.class)
class CarTest {
	private Car carTest;
	
	@BeforeEach
	void setUp() {
		carTest = new Car();
	}
	
	@AfterEach
	void tearDown() {
		carTest = null;
	}
	
	@Test
	@DisplayName("Definir e retornar o modelo do carro")
	@Order(1)
	void testCarSetGetModel() {
		String model = "Ferrari";
		carTest.setModel(model);
		assertEquals(model, carTest.getModel());
	}
	
	@Test
	@DisplayName("Definir e retornar o placa do carro")
	@Order(2)
	void testCarSetGetLicense_plate() {
		String license_plate = "HVK-2233";
		carTest.setLicense_plate(license_plate);
		assertEquals(license_plate, carTest.getLicense_plate());
	}
	
	@Test
	@DisplayName("Definir e retornar o cor do carro")
	@Order(3)
	void testCarSetGetColor() {
		String color = "Azul";
		carTest.setColor(color);
		assertEquals(color, carTest.getColor());
	}
	
	
	@Test
	@DisplayName("Definir e retornar o ano do carro")
	@Order(4)
	void testCarSetGetYear() {
		int year = 2015;
		carTest.setYear(year);
		assertEquals(year, carTest.getYear());
	}
	
	@Test
	@DisplayName("Definir e retornar o valor de aluguel do carro")
	@Order(5)
	void testCarSetGetFine_amount() {
		double fine_amount = 2015;
		carTest.setFine_amount(fine_amount);
		assertEquals(fine_amount, carTest.getFine_amount());
	}
	
	@Test
	@DisplayName("Definir e retornar se o carro está alugado")
	@Order(6)
	void testCarSetGetRent() {
		boolean rent = true;
		carTest.setRent(rent);
		assertEquals(rent, carTest.isRent());
	}
	
	@Test
	@DisplayName("Printar os dados do carro")
	@Order(7)
	void testCarSetGetToString() {
		String model = "Ferrari";
		String license_plate = "HVK-2233";
		String color = "Azul";
		int year = 2015;
		double fine_amount = 2015;
		boolean rent = true;
		
		carTest.setModel(model);
		carTest.setLicense_plate(license_plate);
		carTest.setColor(color);
		carTest.setYear(year);
		carTest.setFine_amount(fine_amount);
		carTest.setRent(rent);
		
		String result = "Modelo= " + model + ", Placa= " + license_plate + ", Cor= " + color + ", Ano= " + year
		+ ", Valor aluguel= " + fine_amount + ", Alugado= " + rent;
		
		assertEquals(result, carTest.toString());
	}

}
