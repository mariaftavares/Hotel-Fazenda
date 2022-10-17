package model;

public abstract class Acomodacao {
	private Boolean reservado;
	private int capacidade;
	private double valorLocacao;
	private String identificador;
	private static int identificadores = 0;
	private String nomeLocacao;
	

	//Construtor
	public Acomodacao(String nomeLocacao) {
		this.identificador = Integer.toString(identificadores++);
		this.nomeLocacao = nomeLocacao;
		this.reservado = false;
	}
	
	public String getNomeLocacao() {
		return nomeLocacao;
	}

	public void setNomeLocacao(String nomeLocacao) {
		this.nomeLocacao = nomeLocacao;
	}
	public double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	
	public static int getIdentificadores() {
		return identificadores;
	}

	public static void setIdentificadores(int identificadores) {
		Acomodacao.identificadores = identificadores;
	}
	
	public Boolean getReservado() {
		return reservado;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
