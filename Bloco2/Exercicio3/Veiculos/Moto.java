package Bloco2.Exercicio3.Veiculos;
import Bloco2.Exercicio3.Veiculo;

public class Moto extends Veiculo {
    // tratando cilindradas como um número inteiro
    public int cilindradas;

    public String toString(){
        return "Marca: " + marca + " Modelo: " + modelo + " Cilindradas: " + cilindradas;
    }
    
    public Moto(String marca, String modelo,int numeroDePortas){
        super(marca, modelo);
        this.cilindradas = numeroDePortas;
    }
}
