package utils;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class Registros {
	private List<Acomodacao> acomodacoes = new ArrayList<Acomodacao>();
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private List<Produto> produtos = new ArrayList<Produto>();
	



	public Registros() {
		//Inserindo dados inciais 
		QuartoUnico quartoUnico = new QuartoUnico("Arara-azul");
		QuartoDuplo quartoduplo = new QuartoDuplo("Onça-pintada");
		Chale chale = new Chale("Capivara", 3);
		ApartamentoDuplo apartamentoduplo = new ApartamentoDuplo("Lontra");
		ApartamentoTriplo apartamentotriplo = new ApartamentoTriplo("Sucuri");
		Produto produto1 = new Produto("Suco de laranja",false,5.00);
		Produto produto2 = new Produto("Cerveja",true,7.00);
		Produto produto3 = new Produto("Refrigerante",false,4.00);
		Produto produto4 = new Produto("Pinga",true,3.00);
		acomodacoes.add(quartoUnico);
		acomodacoes.add(quartoduplo);
		acomodacoes.add(chale);
		acomodacoes.add(apartamentoduplo);
		acomodacoes.add(apartamentotriplo);
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
	}
	
	public List<Acomodacao> getAcomodacoes() {
		return acomodacoes;
	}

	public Acomodacao buscaPorNomeAcomodacao(String nome) {
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
			System.out.println("n°: "+this.reservas.get(i).getIdentificador());
			System.out.println("Nome dos Hospedes da reserva n°"+this.reservas.get(i).getIdentificador());
			for(int a=0; a<this.reservas.get(i).getHospedes().size();a++) {
				System.out.println(this.reservas.get(i).getHospedes().get(a).getNome());
			}
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
	public Integer buscaIdadePorNomeHospede(Reserva reserva,String nome) {
		int idade = 0;
		for(int i = 0;i<reserva.getHospedes().size();i++) {
			if(reserva.getHospedes().get(i).getNome().equals(nome)) {
				idade = reserva.getHospedes().get(i).getIdade();
			}
		}
		
		return idade;
		
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
	
	public void excluirReserva(Reserva reserva) {
		this.reservas.remove(reserva);
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
