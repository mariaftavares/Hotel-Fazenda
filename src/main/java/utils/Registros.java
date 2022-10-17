package utils;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class Registros {
	private List<Acomodacao> acomodacoes = new ArrayList<Acomodacao>();
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private List<Produto> produtos = new ArrayList<Produto>();
	



	public Registros() {
		QuartoUnico quartoUnico = new QuartoUnico("Arara-azul");
		QuartoDuplo quartoduplo = new QuartoDuplo("Onça-pintada");
		Chale chale = new Chale("Capivara", 3);
		
		acomodacoes.add(quartoUnico);
		acomodacoes.add(quartoduplo);
		acomodacoes.add(chale);
	}
	
	public List<Acomodacao> getAcomodacoes() {
		return acomodacoes;
	}

	public Acomodacao buscaPorNome(String nome) {
		Acomodacao acomodacao = null;
		for(int i = 0; i < this.acomodacoes.size(); i++) {
			if(this.acomodacoes.get(i).getNomeLocacao().equals(nome)) {
				acomodacao = this.acomodacoes.get(i);
			}
		}
		
		return acomodacao;
	}
	
	public void mostrarListaDeAcomodacoes() {
		System.out.println("Acomodações Disponíveis");
		for(int i = 0; i < this.acomodacoes.size(); i++) {
			if(this.acomodacoes.get(i).getReservado() == false) {
				System.out.println(this.acomodacoes.get(i).getNomeLocacao()+" Capacidade maxima hospedes:"+this.acomodacoes.get(i).getCapacidade()+" Valor/diaria:"+this.acomodacoes.get(i).getValorLocacao());				
			}
		}
	}
	
	public void listarReservas() {
		for(int i = 0; i < this.reservas.size(); i++) {
			System.out.println("Numero da reserva: " + this.reservas.get(i).getIdentificador());				
		}
	}
	
	public void listarProdutos() {
		for(int i = 0; i < this.produtos.size(); i++) {
			System.out.println("Nome :"+ produtos.get(i).getNome()+ "  Valor:"+produtos.get(i).getValor()+ " Alcoolico:"+produtos.get(i).isAlcoolico());				
		}
	}
	
	public Reserva buscaPorReserva(String identificador) {
		Reserva reserva = null;
		for(int i = 0;i<this.reservas.size();i++) {
			if(this.reservas.get(i).getIdentificador().equals(identificador)) {
				reserva = this.reservas.get(i);
			}
		}
		
		return reserva;
	}
	
	
	public Produto buscaPorProduto(String identificador) {
		Produto produto = null;
		for(int i = 0;i<this.produtos.size();i++) {
			if(this.produtos.get(i).getNome().equals(identificador)) {
				produto = this.produtos.get(i);
			}
		}
		
		return produto;
	}
	
	public void setAcomodacoes(List<Acomodacao> acomodacoes) {
		this.acomodacoes = acomodacoes;
	}
	
	public void adicionarAcomodacao(Acomodacao acomodacao) {
		this.acomodacoes.add(acomodacao);
	}
	
	public void adicionarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
