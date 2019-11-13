package fechaconta;
/**
 *
 * @author kayro
 */
import java.util.*;

public class Mesa {
   Scanner ler = new Scanner(System.in);
   private int numDaMesa;
   private int qtdClienteSentados = 0;
   private int tamMesa;
   private double conta;
   private ArrayList<Cliente> clientesNaMesa = new ArrayList<>();

   public Mesa(int tamMesa, int numDaMesa){
       this.tamMesa = tamMesa;
       this.numDaMesa = numDaMesa;
   }
   
   public ArrayList<Cliente> getClientesNaMesa(){ return clientesNaMesa; }
   
   public int getNumDaMesa(){ return numDaMesa; }
   
   public int getQtdClienteSentados(){ return qtdClienteSentados; }
   
   public void addClienteNaMesa(String nomeCliente){
       if(this.qtdClienteSentados < this.tamMesa){
            clientesNaMesa.add(new Cliente(nomeCliente));
            this.qtdClienteSentados += 1;
            System.out.println("\n[Cliente adicionado]");
       }else{
           System.out.println("\n[Mesa já está cheia]");
       }  
   }
   
   public void removerClienteNaMesa(String nomeCliente){
       if(this.qtdClienteSentados > 0){
           for(int i = 0; i < clientesNaMesa.size(); i++){
               if(nomeCliente.equals(clientesNaMesa.get(i).getNome())){
                    clientesNaMesa.remove(clientesNaMesa.get(i));
                    this.qtdClienteSentados -= 1;
                    System.out.println("\n[Cliente removido]");
                    System.out.print("Gorjeta do garçom: " + (clientesNaMesa.get(i).getConta() * 0.1));
                    System.out.println("\tTotal a pagar: " + (clientesNaMesa.get(i).getConta() + 
                            clientesNaMesa.get(i).getConta() * 0.1));
                    break;
               }else{
                   System.out.println("\n[Cliente não encontrado]");
               }
           }
       }else{
           System.out.println("\n[A mesa está vazia]");
       }  
   }
   
   public double addPedidoM(Menu menu, String nome){
        for(int j = 0; j < clientesNaMesa.size(); j++){
            if(nome.equals(clientesNaMesa.get(j).getNome())){
                return this.clientesNaMesa.get(j).addPedidoC(menu);
            }
        }
        return 0.0;
    }
   
    public double removerPedidoM(Menu menu, String nome){
        for(int j = 0; j < clientesNaMesa.size(); j++){
            if(nome.equals(clientesNaMesa.get(j).getNome())){
                return this.clientesNaMesa.get(j).removerPedidoC(menu);
            }
        }
        return 0.0;
    }
    
   public void printPedidos(){
       for(int j = 0; j < clientesNaMesa.size(); j++){
            System.out.println("    Cliente: " + clientesNaMesa.get(j).getNome());
            System.out.print("\tPedidos: ");
            clientesNaMesa.get(j).printPed();
        }
    }
   
   public void totalDaMesa(){
       double total = 0.0;
       for(int j = 0; j < clientesNaMesa.size(); j++){
           total += clientesNaMesa.get(j).getConta();
       }
       System.out.println("  Total da mesa: R$ " + total);
       System.out.println("  Gorjeta do garçom: R$ " + (total * 0.1));
       System.out.println("===============================");
   }
   
   
}
