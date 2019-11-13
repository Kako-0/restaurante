package fechaconta;
/**
 *
 * @author kayro
 */

public class Comida {
    private String comida;
    private double valor;
    
    public Comida(String comida, double valor){
        this.comida = comida;
        this.valor = valor;
    }
    
    public double getValor(){ return valor; }
    
    public String getComida(){ return comida; }

}
