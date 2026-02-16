package Bloco2.Exercicio3;

import Bloco2.Exercicio3.Veiculos.Carro;
import Bloco2.Exercicio3.Veiculos.Moto;

public class Exercicio3 {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Chevrolet", "Celta");
        Carro carro = new Carro("Volkswagen", "Gol", 4);
        Moto moto = new Moto("Honda", "CG 125", 125);
        
        System.out.println(veiculo.toString()); 
        System.out.println(carro.toString()); 
        System.out.println(moto.toString()); 
    }
}
