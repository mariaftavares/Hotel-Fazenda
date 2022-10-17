package model;

import java.util.List;
import java.util.ArrayList;
public class Reserva {
	private int quantidadePessoas;
	private String contatoResponsavel;
	private List<Acomodacao> acomodacoes;
	private List<Pessoa> hospedes;
	private List <Venda> produtosConsumidos = new ArrayList<Venda>();
	private int quantidaDeDias;
	private String identificador;
	private static int identificadores = 0;
	
	public Reserva(int quantidadePessoas, String contatoResponsavel, List<Acomodacao> acomodacoes, List<Pessoa> hospedes,int quantidaDeDias) {
		this.identificador = Integer.toString(identificadores++);
		this.acomodacoes = acomodacoes;
		this.quantidadePessoas = quantidadePessoas;
		this.contatoResponsavel = contatoResponsavel;
		this.hospedes = hospedes;
		this.quantidaDeDias = quantidaDeDias;
	}
	
	public List<Venda> getProdutosConsumidos() {
		return produtosConsumidos;
	}


	public void setProdutosConsumidos(List<Venda> produtosConsumidos) {
		this.produtosConsumidos = produtosConsumidos;	
	}
	
	public void addProdutoconsumido(Venda venda) {
		this.produtosConsumidos.add(venda);
	}
	
	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public static int getIdentificadores() {
		return identificadores;
	}


	public static void setIdentificadores(int identificadores) {
		Reserva.identificadores = identificadores;
	}


	public int getQuantidadedias() {
		return quantidaDeDias;
	}

	public void setQuantidadedias(int quantidadedias) {
		this.quantidaDeDias = quantidadedias;
	}
	
	public void registrarHospede(Pessoa pessoa) {
		this.hospedes.add(pessoa);
		quantidadePessoas++;
	}
	
	public void registrarAcomodacao(Acomodacao acomodacao) {
		this.acomodacoes.add(acomodacao);
	}
	
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	public String getContatoResponsavel() {
		return contatoResponsavel;
	}
	public void setContatoResponsavel(String contatoResponsavel) {
		this.contatoResponsavel = contatoResponsavel;
	}
	public List<Acomodacao> getAcomodacoes() {
		return acomodacoes;
	}
	public void setAcomodacoes(List<Acomodacao> acomodacoes) {
		this.acomodacoes = acomodacoes;
	}
	public List<Pessoa> getHospedes() {
		return hospedes;
	}
	public void setHospedes(List<Pessoa> hospedes) {
		this.hospedes = hospedes;
	}
	
}
