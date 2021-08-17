package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


import Controller.ClientController;
import Model.Client;

public class ClientControllerTest {
	
	// Testes de adicionar cliente
	@Test
	public void adicionarClienteComNomeNulo() {
		String nome = null;
		String endereco = "Quixada, CE";
		String contato = "92054322";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}

	@Test
	public void adicionarClienteComNomeVazio() {
		String nome = "";
		String endereco = "Quixada, CE";
		String contato = "92054322";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComNomeDeEspacos() {
		String nome = "     ";
		String endereco = "Quixada, CE";
		String contato = "92054322";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoNulo() {
		String nome = "joao";
		String endereco = null;
		String contato = "92054322";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoVazio() {
		String nome = "joao";
		String endereco = "";
		String contato = "92054322";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComEspeciais() {
		String nome = "joao";
		String endereco = "@-ç";
		String contato = "92054322";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComEnderecoComBarraN() {
		String nome = "joao";
		String endereco = "\n";
		String contato = "12345678";
		String cpf = "123.123.123-55";
		
		boolean retorno = clientController.addClient(nome, endereco, contato, cpf);
		assertEquals(false, retorno);
	}
	
	@Test
	public void adicionarClienteComContatoDeUmDigito() {
		String nome = "joao";
		String endereco = "Quixada, CE";
		String contato = "9";
		String cpf = "123.123.123-55";
		
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
	
	@Test
	public void searchClientCaracteresEspeciais() {
		Client c = clientController.searchClient("@Çç#_  _+-\\n");
		assertEquals(null, c);
	}
	
	
	// Teste de remo��o de cliente
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
	
	@Test
	public void removerClienteCaracteresEspeciais() {
		boolean retorno = clientController.removeClient("@Çç#_  _+-\n");
		assertEquals(false, retorno);
	}
	
	
	// Testes de edi��o do cliente
	@Test
	public void editarClienteCpfNulo() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = null;
		boolean retorno = clientController.updateClient(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfVazio() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "";
		boolean retorno = clientController.updateClient(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
	@Test
	public void editarClienteCpfEspecial() {
		String enderecoNovo = "Fortaleza, CE";
		String cpfCliente = "ç\n_-!@#$%¨";
		boolean retorno = clientController.updateClient(cpfCliente, enderecoNovo);
		assertEquals(false, retorno);
	}
	
}
