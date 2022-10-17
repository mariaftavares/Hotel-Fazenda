package model;

public class ApartamentoDuplo extends Acomodacao{

	private boolean pacoteMargarida ;
	private boolean pacoteLuaDeMel ;
	private boolean semPacote ;
	
	// Construtor
	public ApartamentoDuplo(String nomeLocacao) {
		super(nomeLocacao);
		this.setCapacidade(2);
		this.setValorLocacao(140.00);
	}
	
	public boolean isPacoteMargarida() {
		return pacoteMargarida;
	}

	public void setPacoteMargarida(boolean pacoteMargarida) {
		this.pacoteMargarida = pacoteMargarida;
	}

	public boolean isPacoteLuaDeMel() {
		return pacoteLuaDeMel;
	}

	public void setPacoteLuaDeMel(boolean pacoteLuaDeMel) {
		this.pacoteLuaDeMel = pacoteLuaDeMel;
	}

	public boolean isSemPacote() {
		return semPacote;
	}

	public void setSemPacote(boolean semPacote) {
		this.semPacote = semPacote;
	}
}
