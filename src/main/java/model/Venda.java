package model;

public class Venda{
	private Produto produto;
	private int idade;
	
	public Venda (Produto produto,int idade,Reserva reserva) throws Exception {
		validarVenda(idade, produto);
		this.produto = produto;
		this.idade = idade;
	}
	
	private void validarVenda (int idade, Produto produto) throws Exception {
		if(idade < 18 && produto.isAlcoolico()) {
			throw new Exception("Não é possível realizar venda de alcoólicos para menores de Idade");
		}
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
}
