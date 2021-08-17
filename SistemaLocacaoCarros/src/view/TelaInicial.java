package view;

import java.util.Scanner;

import view.TelaAddCarro;
import view.TelaAlugarCarro;
import view.TelaBuscarCarro;
import view.TelaBuscarCliente;
import view.TelaCadastrarCliente;
import view.TelaCarrosDisponiveis;
import view.TelaDevolverCarro;
import view.TelaEditarCliente;
import view.TelaEditarPrecoCarro;
import view.TelaMostrarClientes;
import view.TelaRemoverCarro;
import view.TelaRemoverCliente;
import view.TelaTodosCarros;

public class TelaInicial {

	public static void main(String[] args) {
		boolean stop = false;
		int option;
		Scanner input = new Scanner(System.in);
		while(!stop) {
			System.out.println(" [1] Cadastrar Cliente \n [2] Remover Cliente \n [3] Editar Cliente \n "
					+ "[4] Buscar Cliente \n [5] Mostrar Clientes \n "
					+ "--------------------------------- \n "
					+ "[6] Alugar Carro \n [7] Devolver Carro \n [8] Mostrar alugueis \n"
					+ "--------------------------------- \n "
					+ "[9] Adicionar Carro \n [10] Remover Carro \n [11] Editar preço do carro \n [12] Buscar carro \n [13] Mostrar Carros Disponiveis \n "
					+ "[14] Todos os Carros" );
			option = input.nextInt();
			switch(option) {
			case 1:
				TelaCadastrarCliente.mostrar();
				break;
			case 2:
				TelaRemoverCliente.mostrar();
				break;
			case 3: 
				TelaEditarCliente.mostrar();
				break;
			case 4:
				TelaBuscarCliente.mostrar();
				break;
			case 5:
				TelaMostrarClientes.mostrar();
				break;
				
			case 6:
				TelaAlugarCarro.mostrar();
				break;
			case 7:
				TelaDevolverCarro.mostrar();
				break;
			case 8:
				TelaMostrarAluguel.mostrar();
				break;
				
			case 9:
				TelaAddCarro.mostrar();
				break;
			case 10:
				TelaRemoverCarro.mostrar();
				break;
			case 11:
				TelaEditarPrecoCarro.mostrar();
				break;
			case 12:
				TelaBuscarCarro.mostrar();
				break;
			case 13:
				TelaCarrosDisponiveis.mostrar();
				break;
			case 14:
				TelaTodosCarros.mostrar();
				break;
			default:
				System.out.println("\nOpção inexistente\n");
			}			
		}

	}

}
