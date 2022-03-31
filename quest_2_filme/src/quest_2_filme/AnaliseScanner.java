package quest_2_filme;

import java.util.Scanner;

public class AnaliseScanner {
	
	Scanner texto = new Scanner(System.in);
	int nFilmes;
	int nPaginas;
	int pagEscolhida;
	
	public void iniciarPrograma() {
		System.out.println("Olá, Bem vindo!! \n"
				+ "Vamos organizar nossos filmes? \n"
				+ "Digite 1 para SIM e 2 para finalizar programa:");
		
		boolean loop = true;
		
		while (loop) {
			
		int escolha = texto.nextInt();
		
		if(escolha == 1) {
			analise2();
			loop = false;
		}else if(escolha == 2) {
			System.out.println("Programa finalizado");
			break;
			
		}else if(escolha != 2 & escolha !=1) {
			
			System.out.println("Número invalido, \nFavor Digitar 1 para continuarmos \n"
					+ "ou 2 para finalizar programa");
			
		}
		
		
	}}


	private void analise2() {
		
		System.out.println("\nQuantos filmes deseja exibir?");
		nFilmes = texto.nextInt();
			if(nFilmes > 20 || nFilmes < 1) {
				System.out.println("Valor incorreto, máximo de 20 filmes \n"
						+ "mínimo de 1 filme ");
				analise2();
				
			}else if(nFilmes <= 20) {
				nPaginas = 	Math.round(20F/nFilmes);
					System.out.println("\nO numero de filmes escolhido foi " + 
					nFilmes + ", será distribuido em " + nPaginas + " Páginas."
					+ "\n\n Qual página deseja acessar?");	
						analise3();
			}}
		
	
	private void analise3() {
		
		boolean loop= true;
		
		while(loop) {
			pagEscolhida = texto.nextInt();
				
				if(pagEscolhida > nPaginas
						|| pagEscolhida == 0 ) {
					System.out.println("Valor incorreto, máximo de páginas é " + nPaginas + ".");
		
				}else {
					
					loop = false;
				}
	}
		
}


	public int getnFilmes() {
		return nFilmes;
	}


	public int getPagEscolhida() {
		return pagEscolhida;
	}
	
	
	
	
}