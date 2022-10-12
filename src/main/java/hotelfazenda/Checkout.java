package hotelfazenda;

import java.util.List;

public class Checkout {
	private List<Venda> vendasRealizadas;
	private double valorCheckout;
	
	private Reserva reserva;
	
	private Checkout(Reserva reserva) {
		for(int index = 0; index < reserva.getAcomodacoes().size(); index++) {
			valorCheckout += reserva.getAcomodacoes().get(index).getValorLocacao();
		}
	}
	
	public void realizarVenda(Pessoa pessoa, Produto produto) {
		try {
			Venda venda = new Venda(produto, pessoa);
			vendasRealizadas.add(venda);		
			valorCheckout += venda.getProduto().getValor();
		}
		
		catch(Exception e) {
			System.out.println("Não foi possível realizar a venda:" + e.getMessage());
		}
	}
	
	public double getValorCheckout() {
		return valorCheckout;
	}

	public void setValorCheckout(double valorCheckout) {
		this.valorCheckout = valorCheckout;
	}

	public List<Venda> getVendasRealizadas() {
		return vendasRealizadas;
	}

	public void setVendasRealizadas(List<Venda> vendasRealizadas) {
		this.vendasRealizadas = vendasRealizadas;
	}

	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
}
