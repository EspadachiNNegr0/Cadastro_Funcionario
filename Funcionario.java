package Programa;

public class Funcionario extends Pessoa {
	
	//Atributos especificos da classe que extende pessoa
	
	private double salario;
	private String cargo;
	

	public Funcionario(String nome, int idade, String email, String telefone, String endereco, double salario,String cargo) { //Construtor da classe Funcionario
		super(nome, idade, email, telefone, endereco);
		this.salario = salario;
		this.cargo = cargo;
	}

	// Getters e Setters

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
