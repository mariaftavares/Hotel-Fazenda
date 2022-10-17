package main;

import java.util.Scanner;

import utils.*;

public class Main {
	public static InteracaoUsuario interacao = new InteracaoUsuario();
	public static Utils utils = new Utils(new Scanner(System.in), System.out);
	private static Registros registro = new Registros(); 

	
	public static void main(String[] args) {
			String entradaUsuario;

			while(true) {
				utils.write("Digite a opção desejada:");
				
				utils.write("Cadastrar uma reserva - (1)");
				utils.write("Cadastrar uma acomodação - (2)");
				utils.write("Ir para area de vendas - (3)");
				utils.write("Realizar Checkout - (4)");
				utils.write("Fechar o Programa - (sair)");
				
				entradaUsuario = utils.read();
				
				if(entradaUsuario.equals("sair")) {
					break;				
				}
				else {
					try {
						interacao.executarOpcao(entradaUsuario, registro, utils);
						
					} catch (Exception e) {
						utils.write(String.format("Erro: ", e.getMessage() != null ? e.getMessage() : "Não foi possível executar opção. Por favor selecione novamente."));
					}
				}
			}
			
			utils.write("Fim do Programa");
	}

}
