package br.com.agenda.aplicacao;

import java.util.Scanner;


import br.com.agenda.dao.DestinoDAO;

import br.com.agenda.model.Destino;

public class Main {
																						//classe de execução -ok
																						//união com a classe dao e crud-ok					
	public static void main(String[] args) {											//crud funcinando -ok
		// TODO Auto-generated method stub												//			
		
		try (Scanner input = new Scanner(System.in)) {
			DestinoDAO DestinoDAO = new DestinoDAO();
			
			Destino destino1 = new Destino();
			
		
			
			
			String opcao = "";

			do {
				System.out.println("*** Agencia Maguari ***");
				System.out.println("Digite uma opcao: ");
				System.out.println("(1) - Cadastrar destino");
				System.out.println("(2) - Excluir destino");
				System.out.println("(3) - Pesquisar destino");
				System.out.println("(4) - Exibir todos dos destinos");
				System.out.println("(5) - Atualizar destino");
				System.out.println("(6) - Acabou ? E so finalizar");
				System.out.println("------------------------");
				opcao = input.nextLine();

				switch (opcao) {
				case "1":
					System.out.println("==== Cadastro ====");
					System.out.print("Digite o estado: ");
					destino1.setEstado(input.nextLine());
					
					System.out.print("Digite a cidade: ");
					String cidade = input.nextLine();
					destino1.setCidade(cidade);
					

					System.out.print("Digite a Ida: ");
					int ida = input.nextInt();
					destino1.setIda(ida);
					
				
					System.out.print("Digite a Volta: ");
					int volta = input.nextInt();
					destino1.setVolta(volta);
						
					DestinoDAO.save(destino1); 
					
					System.out.println(" Uhuuuuu ! Contato salvo!");
					break;

				case "2":
					System.out.println("Digite o ID do destino para excluir: ");
					DestinoDAO.removeById(input.nextInt());
					System.out.println("Destino removido com sucesso!");
					break;

				case "3":
					System.out.println("Digite o ID do contato para pesquisa: ");
					int id = input.nextInt();
					Destino d = DestinoDAO.buscarID(id);
					
					System.out.println("Estado: " + d.getEstado());
					System.out.println("Cidade: " + d.getCidade());
					System.out.println("Data da Ida: " + d.getIda());
					System.out.println("Data da Vota: " + d.getVolta());
					
			

					System.out.println("-------------------------------------------------");
					break;

				case "4":
					for (Destino d1 : DestinoDAO.getDestinos()) {
						System.out.println("Nome: " + d1.getEstado());
						System.out.println("Cidade: " + d1.getCidade());
						System.out.println("Data da Ida: " + d1.getIda());
						System.out.println("Data da Vota: " + d1.getVolta());
						System.out.println("-------------------------------------------------");
					}
					break;

				case "5":
					System.out.println("Digite o ID do contato: ");
					int id1 = input.nextInt();
					
					System.out.println("Digite o novo estado: ");
					String estadoo = input.next();
					destino1.setEstado(estadoo);
					
					System.out.println("Digite o nova cidade: ");
					String cidadee = input.next();
					destino1.setEstado(cidadee);
					
					System.out.print("Digite a Ida: ");
					int idaa = input.nextInt();
					destino1.setIda(idaa);
					
				
					System.out.print("Digite a Volta: ");
					int voltaa = input.nextInt();
					destino1.setVolta(voltaa);
					
					destino1.setId(id1);
				
					DestinoDAO.update(destino1);
				
					System.out.println("Dados atualizados!");
				break;
				
				case "6":
					System.out.println("Uma boa viagem ! <3 <3 <3");
					break;
				}

			} while (opcao != "6");
		}
		
		
	}

		
		
}
	
	


