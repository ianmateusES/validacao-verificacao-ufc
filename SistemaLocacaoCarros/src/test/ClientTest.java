package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import model.Client;

class ClientTest {
	private Client clientTest;
	
	@BeforeEach
	void setUp() {
		clientTest = new Client();
	}
	
	@AfterEach
	void tearDown() {
		clientTest = null;
	}
	
	
	@Test
	@DisplayName("Definir e retornar o nome do cliente")
	@Order(1)
	void testCarSetGetModel() {
		String name = "Ian Mateus";
		clientTest.setName(name);
		assertEquals(name, clientTest.getName());
	}
	
	@Test
	@DisplayName("Definir e retornar o endereço do cliente")
	@Order(2)
	void testCarSetGetLicense_plate() {
		String address = "Rua Acula 123";
		clientTest.setAddress(address);
		assertEquals(address, clientTest.getAddress());
	}
	
	@Test
	@DisplayName("Definir e retornar o contato do cliente")
	@Order(3)
	void testCarSetGetColor() {
		String contact = "(85) 98815-1100";
		clientTest.setContact(contact);
		assertEquals(contact, clientTest.getContact());
	}
	
	
	@Test
	@DisplayName("Definir e retornar o cpf do cliente")
	@Order(4)
	void testCarSetGetYear() {
		String cpf = "610.333.444-50";
		clientTest.setCpf(cpf);
		assertEquals(cpf, clientTest.getCpf());
	}
	
	
	@Test
	@DisplayName("Printar os dados do cliente")
	@Order(7)
	void testCarSetGetToString() {
		int id = 1;
		String name = "Ian Mateus";
		String address = "Rua Acula 123";
		String contact = "(85) 98815-1100";
		String cpf = "610.333.444-50";
		
		clientTest.setId(id);
		clientTest.setName(name);
		clientTest.setAddress(address);
		clientTest.setContact(contact);
		clientTest.setCpf(cpf);
		
		String result = id + " Nome=" + name + ", Endereco=" + address + ", Telefone=" + contact + ", CPF=" + cpf;
		
		assertEquals(result, clientTest.toString());
	}

}
