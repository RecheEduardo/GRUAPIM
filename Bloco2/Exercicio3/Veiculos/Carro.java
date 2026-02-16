package Bloco2.Exercicio3.Veiculos;
import Bloco2.Exercicio3.Veiculo;

public class Carro extends Veiculo {
    public int numeroDePortas;

    public String toString(){
        return "Marca: " + marca + " Modelo: " + modelo + " Número de portas: " + numeroDePortas;
    }

    public Carro(String marca, String modelo,int numeroDePortas){
        super(marca, modelo);
        this.numeroDePortas = numeroDePortas;
    }
}
