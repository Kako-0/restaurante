package fechaconta;
/**
 *
 * @author kayro
 */
import java.util.*;

public class Restaurante {
    Scanner ler = new Scanner(System.in);
    private String nomeRestaurante;
    private int qtdMaxMesas;
    private double banco;
    private Menu menu = new Menu();
    ArrayList<Mesa> mesas = new ArrayList<>();
    
    public Restaurante(String nome, int qtdMesas){
        this.qtdMaxMesas = qtdMesas;
        this.nomeRestaurante = nome;
    }
    
    public Menu getMenu(){
        return menu;
    }
    
    public String getNomeRestaurante(){
        return nomeRestaurante;
    }
    
    public boolean verifMesaExiste(int pos){
        for(int i = 0; i < mesas.size(); i++){
            return pos == mesas.get(i).getNumDaMesa();
        }
        return false;
    }
    
    public int addMesa(){
        if(mesas.size() < this.qtdMaxMesas){
            System.out.print("Tamanho da mesa: ");
            int tamMesa = ler.nextInt();
            System.out.print("Qual o número da mesa: ");
            int numMesa = ler.nextInt();
            while(this.verifMesaExiste(numMesa)){
                System.out.print("Numera da mesa já exite, digite outro número: ");
                int outroNum = ler.nextInt();
                numMesa = outroNum;  
            }
            mesas.add(new Mesa(tamMesa, numMesa));
            return numMesa;
        }else{
            System.out.println("\n[Todas as mesas estão ocupadas]");
        }
        return -1;
    }
    
    public void inserirNaMesa(int numMesa, String nomeCliente){
        for(int i = 0; i < mesas.size(); i++){
            if(numMesa == mesas.get(i).getNumDaMesa()){
                this.mesas.get(i).addClienteNaMesa(nomeCliente);
            }
        }
    }
    
    public void deletarNaMesa(int numMesa, String nomeCliente){
        for(int i = 0; i < mesas.size(); i++){
            if(numMesa == mesas.get(i).getNumDaMesa()){
                this.mesas.get(i).removerClienteNaMesa(nomeCliente);
                if(mesas.get(i).getQtdClienteSentados() == 0){
                    this.deleteMesa(numMesa);
                    System.out.println("Mesa também deletada");
                }
            }
        }
    }
    
    public void deleteMesa(int pos){
        for(int i = 0; i < mesas.size(); i++){
            if(pos == mesas.get(i).getNumDaMesa()){
                mesas.remove(i);
                System.out.println("\n[Mesa deletada]");
            }else{
                System.out.println("\n[Mesa não existe]");
            }
        }
    }
    
    public void printMesa(){
        System.out.print("Mesas ocupadas:");
        for(int i = 0; i < mesas.size(); i++){
            System.out.print(" " + mesas.get(i).getNumDaMesa() + ";");
        }
        System.out.println();
    }
    
    public void printMesaToda(){
        double total = 0.0, gorjeta = 0.0;
        for(int i = 0; i < mesas.size(); i++){
            System.out.println("Numero da mesa: " + mesas.get(i).getNumDaMesa());
            mesas.get(i).printPedidos();
            mesas.get(i).totalDaMesa();

        }
    }
    
    public void printTotalNoBanco(){
        System.out.println("\nTotal apurado: R$ " + this.banco + "\nTotal de gorjetas: R$ " + (this.banco * 0.1)
                            + "\nTotal: " + (this.banco + (this.banco * 0.1)));
        System.out.println();
    }

    public void addPedido(int numMesa, String nome){
        for(int i = 0; i < mesas.size(); i++){
            if(numMesa == mesas.get(i).getNumDaMesa()){
                this.banco += mesas.get(i).addPedidoM(menu, nome);
            }
        }
    }
    
    public void removerPedido(int numMesa, String nome){
        for(int i = 0; i < mesas.size(); i++){
            if(numMesa == mesas.get(i).getNumDaMesa()){
                this.banco -= mesas.get(i).removerPedidoM(menu, nome);
            }
        }
    }

}