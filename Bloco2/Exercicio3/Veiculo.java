package Bloco2.Exercicio3;

public class Veiculo {
    public String marca;
    public String modelo;

    public String toString(){
        return "Marca: " + marca + " Modelo: " + modelo;
    }
    
    public Veiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }
}