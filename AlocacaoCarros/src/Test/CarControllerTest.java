package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import Controller.CarController;
import Model.Car;

class CarControllerTest {

	// Testes de adicionar Carros ---------------------
	@Test
	public void adicionarCarValido() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(true, retorno);
		
	}
	
	@Test
	public void adicionarCarmodelNulo() {
		String model = null;
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarmodelVazio() {
		String model = "";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarmodelEspecial() {
		String model = "ç\\n_-!@#$%¨";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	
	@Test
	public void adicionarCarPlacaNulo() {
		String model = "gol";
		String license_plate = null;
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarPlacaVazio() {
		String model = "gol";
		String license_plate = "";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarPlacaEspecial() {
		String model = "gol";
		String license_plate = "ç\\\\n_-!@#$%¨";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarCorNula() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = null;
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarCorVazio() {
		String model = "gol";
		String placa = "AAA0A00";
		String color = "";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, placa, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarCorEspecial() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "ç\\\\\\\\n_-!@#$%¨";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarCarAnoNegativo() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = -2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
		
	}
	
	@Test
	public void adicionarCarAnoSeguinteQueAindaNaoChegou() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = LocalDate.now().getYear() + 1;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
		
	}

	@Test
	public void adicionarCarAnoAntesDaInvencaodoCar1880() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 1879;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
		
	}
	
	@Test
	public void adicionarCarPrecoNegativo() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = -120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
		
	}
	
	@Test
	public void adicionarCarPrecoMenorInteiro() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = Integer.MIN_VALUE;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
		
	}
	
	
	// Testes de remo��o de Carros ---------------------
	@Test
	public void removerCarroValido() {
		adicionarCarValido();
		boolean retorno = carController.removeCar("AAA0A00");
		assertEquals(true, retorno);
	}
	
	@Test
	public void removeyCarroPlacaNula() {
		adicionarCarValido();
		try {
			carController.removeCar(null);
		}catch (IllegalArgumentException ex) {
			assertEquals("placa nao pode ser nula", ex.getMessage());
		}
	}
	
	@Test
	public void removerCarroPlacaVazia() {
		adicionarCarValido();
		boolean retorno = carController.removeCar("");
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerCarroPlacaEspecial() {
		adicionarCarValido();
		boolean retorno = carController.removeCar("Ç/n//!@#%$%&");
		assertEquals(false, retorno);
	}
	
	
	// Teste de buscas de Carros ---------------------
	@Test
	public void buscarCarValido() {
		adicionarCarValido();
		Car c = carController.searchCar("AAA0A00");
		assertEquals("gol", c.getModel());
	}
	
	@Test
	public void buscarCarPlacaNula() {
		adicionarCarValido();
		Car c = carController.searchCar(null);
		assertEquals(null, c);
	}
	
	@Test
	public void buscarCarInexistente() {
		adicionarCarValido();
		Car c = carController.searchCar("hxa1235");
		assertEquals(null, c);
	}
	
	
	// Teste de atualiza��o de carros ---------------------
	@Test
	public void editarCarPrecoNegativo() {
		adicionarCarValido();
		boolean retorno = carController.updateFine_amountl("AAA0A00", -200);
		Car c = carController.searchCar("AAA0A00");
		assertEquals(false, retorno);
		assertEquals(true, c.getFine_amount() == 120);
	}
	
	// Teste de aluguel de Carros ---------------------
	@Test
	public void alugarCarJaALugado() {
		adicionarCarValido();
		carController.rentCar("AAA0A00");
		boolean retorno = carController.rentCar("AAA0A00");
		assertEquals(false, retorno);
	}
	
	@Test
	public void alugarCarInexistente() {
		adicionarCarValido();
		boolean retorno = carController.rentCar("hxa1235");
		assertEquals(false, retorno);
	}
	
	@Test
	public void alugarCarPlacaNula() {
		boolean retorno = carController.rentCar(null);
		assertEquals(false, retorno);
	}
	

}
