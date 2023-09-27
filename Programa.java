package Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Classe principal de execução do programa

public class Programa {
	private static List<Pessoa> pessoas = new ArrayList<>();// Estrutura de dados para armazenar os objetos

	public static void main(String[] args) {

		Programa cadastro = new Programa();   //Instanciando a aplicação
		OperacoesPessoas operacoes = new OperacoesPessoas();  //Instanciando as operações
		cadastro.cadastrarAutomaticamente(pessoas);  //Aplicação cadastra as pessoas

		//Recebendo a opção do usuário e fazendo as operações
		
		Scanner scanner = new Scanner(System.in);
		int opcao;
		do {   
			cadastro.exibirMenu();  //Aplicação exibe o menu
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer

			switch (opcao) {
			case 1:
				operacoes.cadastrarPessoa(pessoas);
				break;
			case 2:
				operacoes.listarPessoas(pessoas);
				break;
			case 3:
				operacoes.buscarEExibirPessoa(pessoas);
				break;
			case 4:
				operacoes.listarPessoasOrdenadas(pessoas);
				break;
			case 5:
				operacoes.buscarERemoverPessoa(pessoas);
				break;
			case 6:
				operacoes.buscarEModificarPessoa(pessoas);
				break;
			case 0:
				System.out.println("Encerrando o programa.");
				break;
			default:
				System.out.println("Opção inválida. Digite um número válido.");
				break;
			}

			System.out.println();
		} while (opcao != 0);
	}
	
	 // Método para apenas exibir o menu
	
	private void exibirMenu() {
		System.out.println("------ MENU ------");
		System.out.println("1. Cadastrar pessoa");
		System.out.println("2. Listar pessoas");
		System.out.println("3. Buscar e exibir pessoa");
		System.out.println("4. Listar pessoas ordenadas");
		System.out.println("5. Buscar e remover pessoa");
		System.out.println("6. Buscar e modificar pessoa");
		System.out.println("0. Sair");
		System.out.print("Digite a opção desejada: ");
	}

	// Método para cadastrar automaticamente pelo menos 7 objetos

	private void cadastrarAutomaticamente(List<Pessoa> pessoas) {
		Pessoa pessoa1 = new Funcionario("João", 25, "joao@gmail.com", "123456789", "Rua A", 1300, "Segurança");
		pessoas.add(pessoa1);

		Pessoa pessoa2 = new Funcionario("Maria", 30, "maria@gmail.com", "987654321", "Rua B", 1500, "Supervisor");
		pessoas.add(pessoa2);

		Pessoa pessoa3 = new Funcionario("Pedro", 35, "pedro@gmail.com", "456789123", "Rua C", 2500, "Gerente");
		pessoas.add(pessoa3);

		Pessoa pessoa4 = new Cliente("Ana", 28, "ana@gmail.com", "321654987", "Rua D");
		pessoas.add(pessoa4);

		Pessoa pessoa5 = new Cliente("Carlos", 32, "carlos@gmail.com", "789123456", "Rua E");
		pessoas.add(pessoa5);

		Pessoa pessoa6 = new Cliente("Mariana", 27, "mariana@gmail.com", "654987321", "Rua F");
		pessoas.add(pessoa6);

		Pessoa pessoa7 = new Cliente("Lucas", 29, "lucas@gmail.com", "147258369", "Rua G");
		pessoas.add(pessoa7);
	}
}