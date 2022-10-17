package utils;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class InteracaoUsuario {
	private void cadastrarAcomodacao(Registros registro, Utils utils) throws Exception{
		utils.write("Informe o nome da nova acomodacao:");
		String nomeacomodacao = utils.read();
		utils.write("Selecione o tipo de acomodacao: ");
		utils.write("Quarto-(1)");
		utils.write("Apartamento-(2)");
		utils.write("Chale-(3)");
		String tipoacomodacao = utils.read();
		if(tipoacomodacao.equals("1")) {
			utils.write("Quarto possui dois tipos de capacidade locacao 1(unico) ou 2(duplo), qual seria?");
			String capacidadelocacao = utils.read();
			if(capacidadelocacao.equals("1")) {
				QuartoUnico novoQuarto = new QuartoUnico(nomeacomodacao);
				registro.adicionarAcomodacao(novoQuarto);
			}
			if(capacidadelocacao.equals("2")) {
				QuartoDuplo novoQuarto = new QuartoDuplo(nomeacomodacao);
				registro.adicionarAcomodacao(novoQuarto);
			}
			
			else {
				utils.write("Invalido");
			}
		}
		if(tipoacomodacao.equals("2")) {
			utils.write("Apartamento possui dois tipos de capacidade locacao 1(duplo) ou 2(triplo), qual seria?");
			String capacidadelocacao = utils.read();
			if(capacidadelocacao.equals("1")) {
				ApartamentoDuplo novoApartamento = new ApartamentoDuplo(nomeacomodacao);
				registro.adicionarAcomodacao(novoApartamento);
			}
			if(capacidadelocacao.equals("2")) {
				ApartamentoTriplo novoApartamento = new ApartamentoTriplo(nomeacomodacao);
				registro.adicionarAcomodacao(novoApartamento);
			}
			
			else {
				utils.write("Invalido");
			}
		}
		
		if(tipoacomodacao.equals("3")) {
			utils.write("O Chale possui a capacidade para até duas pessoas para cada quarto,quantos quartos possui o chalé? ");
			String capacidadelocacao = utils.read();
			Chale novoChale = new Chale(nomeacomodacao,Integer.valueOf(capacidadelocacao));
			registro.adicionarAcomodacao(novoChale);
		}
	}
	
	private void cadastrarReserva(Registros registro, Utils utils) {
		List<Pessoa> hospedes = new ArrayList<Pessoa>();
		List<Acomodacao> acomodacoes = new ArrayList<Acomodacao>();
		
		utils.write("Informe a quantidade de hospedes:");		
		String quantidadeHospedes = utils.read();
		
		utils.write("Informe a quantidade dias que desejam reservar as acomodações:");
		String quantidadeDias = utils.read();
	
		
		Integer quantidadeHospedesValor = Integer.valueOf(quantidadeHospedes);
		
		
		for(int i = 0; i<Integer.valueOf(quantidadeHospedes);i++) {
			utils.write("Cadastro do hospede "+Integer.toString(i+1));
			utils.write("Nome do hospede:");
			String nome = utils.read();
			utils.write("Cpf do hospede:");
			String cpf = utils.read();
			utils.write("Idade do hospede:");
			String idade = utils.read();
			Pessoa hospede = new Pessoa(nome,cpf,Integer.valueOf(idade));
			
			hospedes.add(hospede);
		}
		utils.write("Informe o numero de telefone responsavel:");
		
		String telefoneResponsavel = utils.read();
		
		utils.write("Informe as acomodacoes a serem alocadas:");
		String nomeAcomodacao;
		Acomodacao acomodacao;
		
		while(true) {
			if(quantidadeHospedesValor > 0) {
				registro.mostrarListaDeAcomodacoes();
				utils.write("A acomodações reservadas acomodam até " + (Integer.valueOf(quantidadeHospedes) - quantidadeHospedesValor) + ".");
				utils.write("Ainda restam " + quantidadeHospedesValor + " a serem acomodadas.");
				
				utils.write("Digite o nome da alocaçao a ser reservada: ");
				nomeAcomodacao = utils.read();
				acomodacao = registro.buscaPorNome(nomeAcomodacao);
				
				if(acomodacao == null) {
					utils.write("Não foi localizado a acomodação informada.");
				}
				
				else {
					if(acomodacao.getReservado().equals(true)) {
						utils.write("Acomodação já está reservada.");
					}
					
					else {
						if(acomodacao.getClass().equals(ApartamentoDuplo.class)) {
							utils.write("Para a reserva do apartamento duplo, oferecemos as opções de pacotes gratuitos");
							
							utils.write("Sem Pacote - 1");
							utils.write("Pacote Margarida - 2");
							utils.write("Pacote Lua de Mel - 3");
							
							String pacoteInput = utils.read();
							
							if(pacoteInput.equals("2")) {
								((ApartamentoDuplo) acomodacao).setPacoteMargarida(true);
							}
							
							if(pacoteInput.equals("3")) {
								((ApartamentoDuplo) acomodacao).setPacoteLuaDeMel(true);
							}
							
							else {
								((ApartamentoDuplo) acomodacao).setSemPacote(true);
							}
						}
						quantidadeHospedesValor -= acomodacao.getCapacidade();
						acomodacao.setReservado(true);
						utils.write("A Acomodação " + acomodacao.getNomeLocacao() + " foi reservada com sucesso!");
						acomodacoes.add(acomodacao);	
					}
				}
			}
			
			else {
				break;
			}
		}
		
		Reserva novaReserva = new Reserva(Integer.valueOf(quantidadeHospedes),telefoneResponsavel,acomodacoes,hospedes,Integer.valueOf(quantidadeDias));
		registro.adicionarReserva(novaReserva);
		utils.write("Reserva finalizada com sucesso! Numero da reserva: "+ novaReserva.getIdentificador());
	}
	
	
	private void realizarCheckout(Registros registro, Utils utils) {
		Reserva reserva ;
		String inputUser = null;
		while(true) {
			if(inputUser != "sair") {
				utils.write("Selecione a reserva que deseja fazer o Checkout informando o numero de registro:");
				registro.listarReservas();
				utils.write("Para voltar ao menu principal digite sair");
				inputUser = utils.read();
				if(inputUser.equals("sair")) {
					break;
				}
				reserva = registro.buscaPorReserva(inputUser);
				if(reserva.equals(null)) {
					utils.write("Reserva invalida, por favor digite novamente o identificador da reserva");
				}
				else {
					Checkout checkout = new Checkout(reserva);
					
					utils.write("CheckOut criado!");
					utils.write("Informações da reserva:");
					utils.write("Reserva numero: " + checkout.getReserva().getIdentificador());
					utils.write("Locações Reservadas:");
					for(int i = 0; i < checkout.getReserva().getAcomodacoes().size(); i++) {
						utils.write(checkout.getReserva().getAcomodacoes().get(i).getNomeLocacao());						
					}
					utils.write("Quantidade de dias: "+checkout.getReserva().getQuantidadedias());
					utils.write("Quantidade de hospedes: "+checkout.getReserva().getQuantidadePessoas());
					utils.write("Quantidade de produtos consumidos: "+checkout.getReserva().getProdutosConsumidos().size());
					utils.write("Valor total: "+checkout.getValorTotal());
				}		
			}
			else{
				break;
			}
		}
		utils.write("Checkout finalizado");
	}

	private void areaVendas(Registros registro, Utils utils) {
		String inputUser = "0";
		while(true) {	
			if(inputUser != "sair") {
			utils.write("Bem vindo a area de vendas, selecione a opção:");
			utils.write("Cadastrar um novo produto -(1)");
			utils.write("Realizar uma venda -(2)");
			 inputUser = utils.read();
			if(inputUser.equals("1")) {
				utils.write("Nome do produto:");
				String produtoNome = utils.read();
				utils.write("Valor do produto:");
				String produtoValor = utils.read();
				utils.write("Possui alcool?(true/false)");
				String produtoalcolico = utils.read();
				Produto produtonovo = new Produto(produtoNome,Boolean.valueOf(produtoalcolico),Double.valueOf(produtoValor));
				registro.adicionarProduto(produtonovo);
				utils.write("Produto "+produtonovo.getNome()+" cadastrado com sucesso!");
			}
			if(inputUser.equals("2")) {
				Produto produto ;
				Reserva reserva;
				utils.write("Selecione o produto informando seu nome:");
				registro.listarProdutos();
				String produtoinput = utils.read();
				produto = registro.buscaPorProduto(produtoinput);
				if(produto.equals(null)) {
					utils.write("Produto invalida, por favor digite novamente o nome do produto");
				}
				utils.write("Selecione a reserva que deseja realizar a compra");
				registro.listarReservas();
				String reservainput = utils.read();
				reserva = registro.buscaPorReserva(reservainput);
				if(reserva.equals(null)) {
					utils.write("Reserva invalida, por favor digite novamente o identificador da reserva");
				}
				utils.write("Idade do hospede:");
				String idade = utils.read();
				try {
					Venda novaVenda = new Venda(produto,Integer.valueOf(idade),reserva);
					reserva.addProdutoconsumido(novaVenda);
				}
				catch(Exception err) {
					utils.write(String.valueOf(err));
				}
				
				}
			
				if(inputUser.equals("sair")) {
					break;
				}
			
			}
		}
	}
	
	
	
	
	public void executarOpcao(String input, Registros registro, Utils utils) throws Exception{
		if(input.equals("1")) {
			cadastrarReserva(registro, utils);
		}
		if(input.equals("2")){
			cadastrarAcomodacao(registro, utils);
		}
		if(input.equals("3")){
			areaVendas(registro, utils);
		}
		if(input.equals("4")){
			realizarCheckout(registro, utils);
		}
	}

	
	
}
