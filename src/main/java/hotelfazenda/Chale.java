package hotelfazenda;

public class Chale extends Acomodacao{
	
	private int quantidadeQuartos;
	
	public Chale(String nomeLocacao, int quantidadeQuartos) {
		super(nomeLocacao);
		this.quantidadeQuartos = quantidadeQuartos;
		
		this.setCapacidade(quantidadeQuartos * 2);
		this.setValorLocacao(quantidadeQuartos * 100);
	}

	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}

	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}
}
