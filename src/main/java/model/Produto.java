package model;

public class Produto {
	private String nome;
	private boolean alcoolico;
	private double valor;
	
	public Produto(String nome, boolean alcoolico, double valor) {
		this.nome = nome;
		this.alcoolico = alcoolico;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAlcoolico() {
		return alcoolico;
	}
	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
