package fechaconta;
/**
 *
 * @author kayro
 */
import java.util.*; 

public class Cliente {
    Scanner ler = new Scanner(System.in);
    private String nome;
    private double conta = 0.0;
    private ArrayList<String> pedidos;
    
    public Cliente(String nome){
        this.nome = nome;
        pedidos = new ArrayList<>();
    }
    
    public ArrayList<String> getPedidos(){ return pedidos; }
    
    public String getNome(){ return nome; }
    
    public double getConta(){ return conta; }
    
    public double addPedidoC(Menu menu){
	System.out.print("Quantos items deseja pedir?: ");
	int n = ler.nextInt();
	double valor = 0.0;
	for(int i = 0; i < n; i++) {
            ler.nextLine();
            System.out.printf("Qual nome do item do menu deseja? ");
            String item = ler.nextLine();
            System.out.print("Quantidade: ");
            int qtd = ler.nextInt();
            for(int j = 0; j < menu.getCardapio().size(); j++){
                if(item.equals(menu.getCardapio().get(j).getComida())){
                    valor = menu.getCardapio().get(j).getValor();
                } else {
                    System.out.println("\n[Item não encontrado]");
                    valor += 0.0;
                }
            }
            if(qtd > 0 && valor > 0.0) { 
                this.conta += (valor * qtd);
                for(int j = 0; j < qtd; j++) {
                    pedidos.add(item);
		}
                System.out.println("\n[Pedido feito]");
                return (valor * qtd);
            }else{
                System.out.println("\n[Erro ao inserir pedido]");
            }
        }
        return 0.0;
    }
    
    public double removerPedidoC(Menu menu){
        System.out.print("Quantos items deseja remover?: ");
	int n = ler.nextInt();
	double valor = 0.0;
	for(int i = 0; i < n; i++) {
            ler.nextLine();
            System.out.print("Qual nome do item que deseja remover?: ");
            String item = ler.nextLine();
            System.out.print("Quantidade: ");
            int qtd = ler.nextInt();
            for(int j = 0; j < menu.getCardapio().size(); j++){
                if(item.equals(menu.getCardapio().get(j).getComida())){
                    valor = menu.getCardapio().get(j).getValor();
                }
            }
            if(qtd > 0 && valor > 0.0) {
                this.conta -= (valor * qtd);
                for(int j = 0; j < qtd; j++) {
                    pedidos.remove(item);
		}
                System.out.println("\n[Pedido desfeito]");
                return (valor * qtd);
            }else{
                System.out.println("\n[Erro ao remover]");
            }
        }
        return 0.0;
    }
    
    public void printPed(){
        for (int i = 0; i < pedidos.size(); i++){
            System.out.print(pedidos.get(i) + "; ");
        }
        System.out.println();
    }

}
