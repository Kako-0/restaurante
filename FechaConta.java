package fechaconta;
/**
 * @author kayro
 */
import java.util.*;
public class FechaConta {
    
    public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);
       Restaurante rest = null;
		boolean out = false;
		
		while(out != true) {
			System.out.println("");
			System.out.println("[1] Registrar Restaurante");  
			System.out.println("[2] Inserir um cliente"); //um cliente pode sentar em uma mesa vazia, ou se juntar a uma já ocupada
			System.out.println("[3] Remover um cliente"); //o cliente sai da mesa e tem sua conta individual fechada automaticamente
			System.out.println("[4] Inserir um pedido"); //printa o cardápio durante o pedido e adiciona um pedido
			System.out.println("[5] Remover um pedido"); //remove um pedido de um cliente especifico
                        System.out.println("[6] Emitir contas em aberto"); //imprime todas as contas em atendimento de todas as mesas
			System.out.println("[7] Fechar a conta"); //fecha a conta de uma mesa específica
			System.out.println("[8] Encerrar o dia"); //fecha a conta de todas as mesas ainda existentes
			System.out.print("Opcao escolhida: ");
			int opcao = ler.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("\n[OPCAO 1 - RESGISTRAR RESTAURANTE]\n");
					if(rest == null) {
						System.out.print("Nome: ");
						ler.nextLine();
						String nome = ler.nextLine();
						
						System.out.print("Total de mesas que o restaurante possui: ");
						int qtdMesas =ler.nextInt();
						rest = new Restaurante(nome, qtdMesas);
                                                rest.getMenu().multiAddComida();
						System.out.println("\n[Restaurante registrado com sucesso!]");
					}else {
						System.out.println("\n[Restaurante ja registrado!]");
					}
					break;
				case 2:
					System.out.println("\n[OPCAO 2 - ADICIONAR CLIENTE]\n");
					if(rest != null) {
						System.out.print("Nome do cliente: ");
					ler.nextLine();
						String nome =ler.nextLine();
						System.out.println("O cliente irá...");
						System.out.println("[1] Sentar-se em uma mesa vazia");
						System.out.println("[2] Juntar-se a uma mesa ocupada");
						System.out.print("Opcao escolhida.: ");
						int choice =ler.nextInt();
						if(choice == 1) {
							int aux = rest.addMesa();
                                                        rest.inserirNaMesa(aux, nome);
							
						}else if(choice == 2){
							rest.printMesa();
							System.out.print("A qual mesa o cliente ira se juntar?: ");
							int nMesa =ler.nextInt();
							rest.inserirNaMesa(nMesa, nome );
						}else {
							System.out.println("[OPCAO INVALIDA!]");
						}
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 3:
					System.out.println("\n[OPCAO 3 - REMOVER CLIENTE]\n");
					if(rest != null) {
						rest.printMesa();
						System.out.print("Qual mesa o cliente está? ");
						int nMesa =ler.nextInt();
						System.out.print("Nome do cliente: ");
                                                ler.nextLine();
						String nome =ler.nextLine();
						rest.deletarNaMesa(nMesa, nome);
					}
					break;
				case 4:
					System.out.println("\n[OPCAO 4 - INSERIR UM PEDIDO]\n");
					if(rest != null) {
						rest.printMesa();
						System.out.print("\nO pedido sera feito em qual mesa? ");
						int nMesa =ler.nextInt();
						System.out.print("Qual cliente ira fazer o pedido? ");
                                                ler.nextLine();
						String nome =ler.nextLine();
                                                rest.getMenu().mostraMenu();
						rest.addPedido(nMesa, nome);
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 5:
					System.out.println("\n[OPCAO 5 - REMOVER UM PEDIDO]\n");
					if(rest != null) {
						rest.printMesa();
						System.out.print("O pedido sera removido em qual mesa? ");
						int nMesa =ler.nextInt();
						System.out.print("Qual cliente ira remover o pedido? ");
					ler.nextLine();
						String nome =ler.nextLine();
						rest.removerPedido(nMesa, nome);
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
                                case 6:
                                        System.out.println("\n[OPCAO 6 - EMITIR CONTAS EM ABERTO]\n");
                                        rest.printMesaToda();
                                        break;
				case 7:
					System.out.println("\n[OPCAO 7 - FECHAR A CONTA]\n");
					if(rest != null) {
						rest.printMesa();
						System.out.print("Qual mesa ira fechar a conta?: ");
						int nMesa =ler.nextInt();
						rest.deleteMesa(nMesa);
						System.out.println("\n[Conta fechada com sucesso!]");
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				case 8:
					System.out.println("\n[OPCAO 8 - ENCERRAR O DIA]\n");
					if(rest != null) {
						System.out.println("[Restaurante " + rest.getNomeRestaurante() + "]");
						rest.printTotalNoBanco();
						System.out.println("[Dia encerrado com sucesso!]");
						out = true;
					}else {
						System.out.println("\n[Restaurante nao existe!]");
					}
					break;
				default:
					System.out.println("\n[OPCAO INVALIDA!]\n");
					break;
                                        
			}
		}
	ler.close();
    }
}

