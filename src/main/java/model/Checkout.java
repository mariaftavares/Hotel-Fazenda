package model;

import java.util.List;

public class Checkout {
	private List<Venda> vendasRealizadas;
	private double valorDiariaTotal;
	private double valorTotal;
	
	private Reserva reserva;
	
	public Checkout(Reserva reserva) {
		this.reserva = reserva;
		for(int index = 0; index < this.reserva.getAcomodacoes().size(); index++) {
			this.valorDiariaTotal += this.reserva.getAcomodacoes().get(index).getValorLocacao();
			this.reserva.getAcomodacoes().get(index).getReservado().equals(false);
			this.valorTotal = this.valorDiariaTotal * this.reserva.getQuantidadedias();
		}
		for(int i = 0; i < this.reserva.getProdutosConsumidos().size();i++) {
			this.valorTotal += this.reserva.getProdutosConsumidos().get(i).getProduto().getValor();
		}
	}
	
	
	public double getValorCheckout() {
		return valorDiariaTotal;
	}

	public void setValorCheckout(double valorCheckout) {
		this.valorDiariaTotal = valorCheckout;
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
	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
