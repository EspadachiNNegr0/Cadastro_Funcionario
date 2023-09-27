package Programa;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OperacoesPessoas {
    public void cadastrarPessoa(List<Pessoa> pessoas) {   // Método para cadastrar uma pessoa manualmente
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ CADASTRO ------");
        System.out.println("1. Cliente ");
        System.out.println("2. Funcionário ");
        System.out.print("Escolha o tipo de pessoa para cadastro: ");
        int tipoCadastro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        if (tipoCadastro == 1) {
            // Cadastro de Cliente
            Cliente cliente = new Cliente(nome, idade, email, telefone, endereco);
            System.out.println("Cliente cadastrado com sucesso!");
            pessoas.add(cliente);
        } else if (tipoCadastro == 2) {
            // Cadastro de Funcionário
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            
            Funcionario funcionario = new Funcionario(nome, idade, email, telefone, endereco, salario, cargo);
            System.out.println("Funcionário cadastrado com sucesso!");
            pessoas.add(funcionario);
        } else {
            System.out.println("Opção inválida!");
        }
        
    }


    public void listarPessoas(List<Pessoa> pessoas) {   //Método para listar as pessoas cadastradas (exibindo apenas 3 atributos)
        System.out.println("------ LISTA DE PESSOAS ------");
        System.out.println("Nome\tIdade\tE-mail");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + "\t" + pessoa.getIdade() + "\t" + pessoa.getEmail());
        }
    }

    public void buscarEExibirPessoa(List<Pessoa> pessoas) {   //Método para buscar e exibir uma pessoa a partir do nome
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
            	if(pessoa instanceof Cliente) {
            		Cliente cliente = (Cliente) pessoa;// Pessoa vira Cliente usando downcasting
                    System.out.println("------ CLIENTE ENCONTRADO ------");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("E-mail: " + cliente.getEmail());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Endereço: " + cliente.getEndereco());
                    encontrada = true;
                    break;
                	}else if(pessoa instanceof Funcionario) {
                		Funcionario funcionario = (Funcionario) pessoa; // Pessoa vira funcionário usando downcasting
                        System.out.println("------ FUNCIONÁRIO ENCONTRADO ------");
                        System.out.println("Nome: " + funcionario.getNome());
                        System.out.println("Idade: " + funcionario.getIdade());
                        System.out.println("E-mail: " + funcionario.getEmail());
                        System.out.println("Telefone: " + funcionario.getTelefone());
                        System.out.println("Endereço: " + funcionario.getEndereco());
                        System.out.println("Salário: R$ " + funcionario.getSalario());
                        System.out.println("Cargo: " + funcionario.getCargo());
                        encontrada = true;
                        break;
                	}
                }
            }
            if (!encontrada) {
                System.out.println("Pessoa não encontrada!");
            }
        }

    public void listarPessoasOrdenadas(List<Pessoa> pessoas) {   //Método para listar as pessoas cadastradas em ordem alfabética por nome
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            Collections.sort(pessoas, new PessoaComparator());

            System.out.println("------ PESSOAS ORDENADAS POR NOME ------");
            System.out.println("Nome\tIdade\tE-mail");

            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa.getNome() + "\t" + pessoa.getIdade() + "\t" + pessoa.getEmail());
            }
        }
    }

    public void buscarERemoverPessoa(List<Pessoa> pessoas) {  //Método para buscar e remover uma pessoa a partir do nome
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
				if (pessoa instanceof Cliente) {
					Cliente cliente = (Cliente) pessoa;// Pessoa vira Cliente usando downcasting
					System.out.println("------ CLIENTE ENCONTRADO ------");
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("Idade: " + cliente.getIdade());
					System.out.println("E-mail: " + cliente.getEmail());
					System.out.println("Telefone: " + cliente.getTelefone());
					System.out.println("Endereço: " + cliente.getEndereco());
					System.out.print("Deseja remover essa pessoa? (S/N): ");
					String confirmacao = scanner.nextLine();
					if (confirmacao.equalsIgnoreCase("S")) {
						pessoas.remove(pessoa);
						System.out.println("Pessoa removida com sucesso!");
					} else {
						System.out.println("Remoção cancelada.");
					}
					encontrada = true;
					break;
				} else if (pessoa instanceof Funcionario) {
					Funcionario funcionario = (Funcionario) pessoa; // Pessoa vira funcionário
					System.out.println("------ FUNCIONÁRIO ENCONTRADO ------");
					System.out.println("Nome: " + funcionario.getNome());
					System.out.println("Idade: " + funcionario.getIdade());
					System.out.println("E-mail: " + funcionario.getEmail());
					System.out.println("Telefone: " + funcionario.getTelefone());
					System.out.println("Endereço: " + funcionario.getEndereco());
					System.out.println("Salário: R$ " + funcionario.getSalario());
					System.out.println("Cargo: " + funcionario.getCargo());
					System.out.print("Deseja remover essa pessoa? (S/N): ");
					String confirmacao = scanner.nextLine();
					if (confirmacao.equalsIgnoreCase("S")) {
						pessoas.remove(pessoa);
						System.out.println("Pessoa removida com sucesso!");
					} else {
						System.out.println("Remoção cancelada.");
					}
					encontrada = true;
					break;
				}
				if (!encontrada) {
					System.out.println("Pessoa não encontrada!");
				}
			}
		}
	}

    public void buscarEModificarPessoa(List<Pessoa> pessoas) {   // Método para buscar e modificar uma pessoa a partir do nome
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nomeBusca = scanner.nextLine();

        boolean encontrada = false;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
                	if(pessoa instanceof Cliente) {
                	Cliente cliente = (Cliente) pessoa;// Pessoa vira Cliente usando downcasting
                    System.out.println("------ CLIENTE ENCONTRADO ------");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Idade: " + cliente.getIdade());
                    System.out.println("E-mail: " + cliente.getEmail());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Endereço: " + cliente.getEndereco());
                    System.out.print("Deseja modificar essa pessoa? (S/N): ");
                    String confirmacao = scanner.nextLine();
                    if (confirmacao.equalsIgnoreCase("S")) {
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        pessoa.setNome(novoNome);
                        System.out.println("Pessoa modificada com sucesso!");
                    } else {
                        System.out.println("Modificação cancelada.");
                    }
                    encontrada = true;
                    break;
                }else if(pessoa instanceof Funcionario) {
                		Funcionario funcionario = (Funcionario) pessoa; // Pessoa vira funcionário
                        System.out.println("------ FUNCIONÁRIO ENCONTRADO ------");
                        System.out.println("Nome: " + funcionario.getNome());
                        System.out.println("Idade: " + funcionario.getIdade());
                        System.out.println("E-mail: " + funcionario.getEmail());
                        System.out.println("Telefone: " + funcionario.getTelefone());
                        System.out.println("Endereço: " + funcionario.getEndereco());
                        System.out.println("Salário: R$ " + funcionario.getSalario());
                        System.out.println("Cargo: " + funcionario.getCargo());
                        System.out.print("Deseja modificar essa pessoa? (S/N): ");
                        String confirmacao = scanner.nextLine();
                        if (confirmacao.equalsIgnoreCase("S")) {
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            pessoa.setNome(novoNome);
                            System.out.println("Pessoa modificada com sucesso!");
                        } else {
                            System.out.println("Modificação cancelada.");
                        }
                        encontrada = true;
                        break;
                    }
                }
            } 

            if (!encontrada) {
                System.out.println("Pessoa não encontrada!");
            }
        }
    }
