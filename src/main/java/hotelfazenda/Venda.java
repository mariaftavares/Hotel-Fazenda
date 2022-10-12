package hotelfazenda;

public class Venda{
	private Produto produto;
	private Pessoa pessoa;
	
	public Venda (Produto produto, Pessoa pessoa) throws Exception {
		
		validarVenda(pessoa, produto);
		
		this.produto = produto;
		this.pessoa = pessoa;
	}
	
	private void validarVenda (Pessoa pessoa, Produto produto) throws Exception {
		if(pessoa.getIdade() < 18 && produto.isAlcoolico()) {
			throw new Exception("Não é possível realizar venda de alcoólicos para menores de Idade");
		}
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
