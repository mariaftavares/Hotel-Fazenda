package hotelfazenda;

public class ApartamentoTriplo extends Acomodacao{

	public ApartamentoTriplo (String nomeLocacao) {
		super(nomeLocacao);
		this.setCapacidade(3);
		this.setValorLocacao(190.00);
	}
}
