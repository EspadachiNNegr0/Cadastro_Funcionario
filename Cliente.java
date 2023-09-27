package Programa;

public class Cliente extends Pessoa{
	
	//Classe que extende pessoa (apenas para a coerência do programa com a realidade)

	public Cliente(String nome, int idade, String email, String telefone, String endereco) { //Construtor da classe Cliente
		super(nome, idade, email, telefone, endereco);
	}

}
