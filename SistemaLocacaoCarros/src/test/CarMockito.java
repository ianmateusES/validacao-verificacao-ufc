package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import controller.CarController;
import dao.CarDAO;
import model.Car;

class CarMockito {
	private CarController carController;
	
	private List<Car> cars;
	
	@BeforeEach
	void setUp() throws SQLException {	
		cars = new ArrayList<Car>();
		
		CarDAO carDAOMock = Mockito.mock(CarDAO.class);
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Car car = (Car) invocation.getArguments()[0];
				cars.add(car);
				if (cars.contains(car)) return true;
				return false;
			}
			
		}).when(carDAOMock).create(Mockito.any(Car.class));
		
		Mockito.when(carDAOMock.list()).thenReturn(cars);
		
		Mockito.doAnswer(new Answer<Car>() {
			@Override
			public Car answer(InvocationOnMock invocation) throws Throwable {
				String license_plate = (String) invocation.getArguments()[0];
				for (Car car : cars) {
					if(car.getLicense_plate() == license_plate) return car;
				}
				return null;
			}
			
		}).when(carDAOMock).search_license_plate(Mockito.any(String.class));
		
		
		Mockito.doAnswer(new Answer<List<Car>>() {
			@Override
			public List<Car> answer(InvocationOnMock invocation) throws Throwable {
				boolean available = (boolean) invocation.getArguments()[0];
				List<Car> carAvailable = new ArrayList<Car>();
				for (Car car : cars) {
					if(car.isAvailable() == available) carAvailable.add(car);
				}
				if(carAvailable.isEmpty()) return null;
				
				return carAvailable;
			}
			
		}).when(carDAOMock).list_available(Mockito.any(boolean.class));
		
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String license_plate = (String) invocation.getArguments()[0];
				float fine_amount = (float) invocation.getArguments()[1];
				for (Car car : cars) {
					if(car.getLicense_plate() == license_plate) {
						car.setFine_amount(fine_amount);
						return true;
					}
				}
				return false;
			}
			
		}).when(carDAOMock).update_fine_amount(Mockito.any(String.class), Mockito.any(float.class));
		
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String license_plate = (String) invocation.getArguments()[0];
				boolean available = (boolean) invocation.getArguments()[1];
				for (Car car : cars) {
					if(car.getLicense_plate() == license_plate) {
						car.setAvailable(available);
						return true;
					}
				}
				return false;
			}
			
		}).when(carDAOMock).update_available(Mockito.any(String.class), Mockito.any(boolean.class));
		
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String license_plate = (String) invocation.getArguments()[0];
				for (Car car : cars) {
					if(car.getLicense_plate() == license_plate) {
						cars.remove(car);
						return true;
					};
				}
				return false;
			}
			
		}).when(carDAOMock).delete(Mockito.any(String.class));
		
		carController = new CarController(carDAOMock);
	}

	@Test
	@DisplayName("Deve adicionar carro")
	@Order(1)
	void adicionarCarroValido() throws SQLException {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(true, retorno);
		
	}
	
	@Test
	@DisplayName("Não deve adicionar carro com modelo nula")
	@Order(2)
	public void adicionarCarroModeloNulo() {
		String model = null;
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	@DisplayName("Não deve adicionar carro com modelo vazio")
	@Order(3)
	public void adicionarCarroModeloVazio() {
		String model = "";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	@DisplayName("Não deve adicionar carro com placa nula")
	@Order(4)
	public void adicionarCarroPlacaNulo() {
		String model = "gol";
		String license_plate = null;
		String color = "branco";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	@DisplayName("Não deve adicionar carro com placa vazio")
	@Order(5)
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
	@DisplayName("Não deve adicionar carro com cor nula")
	@Order(6)
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
	@DisplayName("Não deve adicionar carro com cor vazio")
	@Order(7)
	public void adicionarCarCorVazio() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "";
		int year = 2015;
		float fine_amountl = 120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	@Test
	@DisplayName("Não deve adicionar carro com ano negativo")
	@Order(8)
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
	@DisplayName("Não deve adicionar carro com ano maior que atual")
	@Order(9)
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
	@DisplayName("Não deve adicionar carro com ano menor que o minimo")
	@Order(10)
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
	@DisplayName("Não deve adicionar carro com preço negativo")
	@Order(11)
	public void adicionarCarPrecoNegativo() {
		String model = "gol";
		String license_plate = "AAA0A00";
		String color = "branco";
		int year = 2015;
		float fine_amountl = -120;
		
		boolean retorno = carController.addCar(model, license_plate, color, year, fine_amountl);
		assertEquals(false, retorno);
	}
	
	// Testes de remocao de Carros ---------------------
	@Test
	public void removerCarroValido() throws SQLException {
		adicionarCarroValido();
		boolean retorno = carController.removeCar("AAA0A00");
		assertEquals(true, retorno);
	}
	
	@Test
	public void removerCarroPlacaVazia() throws SQLException {
		adicionarCarroValido();
		boolean retorno = carController.removeCar("");
		assertEquals(false, retorno);
	}
	
	// Teste de buscas de Carros ---------------------
	@Test
	public void buscarCarValido() throws SQLException {
		adicionarCarroValido();
		Car c = carController.searchCar("AAA0A00");
		assertEquals("gol", c.getModel());
	}
	
	@Test
	public void buscarCarPlacaNula() throws SQLException {
		adicionarCarroValido();
		Car c = carController.searchCar(null);
		assertEquals(null, c);
	}
	
	@Test
	public void buscarCarInexistente() throws SQLException {
		adicionarCarroValido();
		Car c = carController.searchCar("hxa1235");
		assertEquals(null, c);
	}
	
	
	// Teste de atualizao de carros ---------------------
	@Test
	public void editarCarPrecoNegativo() throws SQLException {
		adicionarCarroValido();
		boolean retorno = carController.updateFine_amount("AAA0A00", -200);
		Car c = carController.searchCar("AAA0A00");
		assertEquals(false, retorno);
		assertEquals(true, c.getFine_amount() == 120);
	}
	
}
