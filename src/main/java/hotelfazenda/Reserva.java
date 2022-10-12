package hotelfazenda;

import java.util.List;

public class Reserva {
	private int quantidadePessoas;
	private String contatoResponsavel;
	private List<Acomodacao> acomodacoes;
	private List<Pessoa> hospedes;
	
	public Reserva(String contatoResponsavel, List<Acomodacao> acomodacoes, List<Pessoa> hospedes) {
		this.acomodacoes = acomodacoes;
		this.contatoResponsavel = contatoResponsavel;
		this.hospedes = hospedes;
	}
	
	public Reserva(int quantidadePessoas, String contatoResponsavel, List<Acomodacao> acomodacoes, List<Pessoa> hospedes) {
		this.acomodacoes = acomodacoes;
		this.quantidadePessoas = quantidadePessoas;
		this.contatoResponsavel = contatoResponsavel;
		this.hospedes = hospedes;
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
