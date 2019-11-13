package fechaconta;
/**
 *
 * @author kayro
 */
import java.util.*;
public class Menu {
    Scanner ler = new Scanner(System.in);
    private ArrayList<Comida> cardapio = new ArrayList<>();
    
    
    public ArrayList<Comida> getCardapio(){ return cardapio; }
    
    public void addComida(){
        ler.nextLine();
        System.out.print("Nome da comida: ");
        String comida = ler.nextLine();
        System.out.print("Preço: ");
        double preco = ler.nextDouble();
        
        cardapio.add(new Comida(comida, preco));
    }
    
    public void multiAddComida(){
        System.out.print("Quantos pratos deseja adicionar? ");
        int qtd = ler.nextInt();
        for(int i = 0; i < qtd; i++){
            this.addComida();
        }
    }
    
    public void mostraMenu(){
        System.out.println("---------> MENU <---------");
        for(int i = 0; i < cardapio.size(); i++){
            System.out.println((i+1) + "- " + cardapio.get(i).getComida() + " R$: " + cardapio.get(i).getValor());
        }
        
    }
    
}
