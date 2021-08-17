package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import controller.ClientController;
import dao.ClientDAO;
import model.Client;

class ClientMockito {
	private ClientController clientController;
	
	private List<Client> clients;
	
	@BeforeEach
	void setUp() throws SQLException {	
		clients = new ArrayList<Client>();
		
		ClientDAO clientDAOMock = Mockito.mock(ClientDAO.class);
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Client client = (Client) invocation.getArguments()[0];
				clients.add(client);
				if (clients.contains(client)) return true;
				return false;
			}
			
		}).when(clientDAOMock).create(Mockito.any(Client.class));
		
		Mockito.when(clientDAOMock.list()).thenReturn(clients);
		
		Mockito.doAnswer(new Answer<Client>() {
			@Override
			public Client answer(InvocationOnMock invocation) throws Throwable {
				String cpf = (String) invocation.getArguments()[0];
				for (Client client : clients) {
					if(client.getCpf() == cpf) return client;
				}
				return null;
			}
			
		}).when(clientDAOMock).search_cpf(Mockito.any(String.class));
		
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String cpf = (String) invocation.getArguments()[0];
				String name = (String) invocation.getArguments()[1];
				String address = (String) invocation.getArguments()[2];
				for (Client client : clients) {
					if(client.getCpf() == cpf) {
						client.setName(name);
						client.setAddress(address);
						return true;
					}
				}
				return false;
			}
			
		}).when(clientDAOMock).update(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class));
		
		
		Mockito.doAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				String cpf = (String) invocation.getArguments()[0];
				for (Client client : clients) {
					if(client.getCpf() == cpf) {
						clients.remove(client);
						return true;
					}
				}
				return false;
			}
			
		}).when(clientDAOMock).delete(Mockito.any(String.class));
		
		clientController = new ClientController(clientDAOMock);
	}
	
	
	// Testes de adicionar cliente
	@Test
	public void adicionarClienteValido() {
		String nome = "Ian";
		String endereco = "Quixada, CE";
		String contato = "85988887777";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(true, retorno);
	}
	
	@Test
	public void adicionarClienteComNomeNulo() {
		String nome = null;
		String endereco = "Quixada, CE";
		String contato = "92054322";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}

	@Test
	public void adicionarClienteComNomeVazio() {
		String nome = "";
		String endereco = "Quixada, CE";
		String contato = "92054322";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComNomeDeEspacos() {
		String nome = "  ";
		String endereco = "Quixada, CE";
		String contato = "92054322";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoNulo() {
		String nome = "joao";
		String endereco = null;
		String contato = "92054322";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoVazio() {
		String nome = "joao";
		String endereco = "";
		String contato = "92054322";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComBarraN() {
		String nome = "joao";
		String endereco = "\n";
		String contato = "12345678";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComContatoDeUmDigito() {
		String nome = "joao";
		String endereco = "Quixada, CE";
		String contato = "9";
		String cpf = "12312312355";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}

	
	// Testes de buscas do cliente
	@Test
	public void searchClientCpfNulo() {
		Client c = clientController.searchClient(null);
		assertEquals(null, c);
	}
	
	@Test
	public void searchClientCpfVazio() {
		Client c = clientController.searchClient("");
		assertEquals(null, c);
	}
	
	
	// Teste de remocao de cliente
	@Test
	public void removerClienteCpfNulo() {
		boolean retorno = clientController.removeClient(null);
		assertEquals(false, retorno);
	}
	
	@Test
	public void removerClienteCpfVazio() {
		boolean retorno = clientController.removeClient("");
		assertEquals(false, retorno);
	}
	
	
	// Testes de edicao cliente
	@Test
	public void editarClienteCpfNulo() {
		String nome = "joao";
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = null;
		boolean retorno = clientController.updateClient(cpfCliente, nome, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfVazio() {
		String nome = "joao";
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "";
		boolean retorno = clientController.updateClient(cpfCliente, nome, enderecoNovo);
		assertEquals(false, retorno);
	}

}
