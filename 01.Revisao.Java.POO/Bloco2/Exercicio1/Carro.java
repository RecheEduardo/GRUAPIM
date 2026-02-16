package Bloco2.Exercicio1;

public class Carro {
    // propriedades
    private String marca;
    private String modelo;
    private int ano;

    // getters
    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void exibirInfos() {
        System.out.println("Marca: " + marca + " / Modelo: " + modelo + " / Ano: " + ano);
    }

    // construtor: aqui fiquei em duvida se era parametrizado ou não, então parametrizei
    public Carro(int ano, String modelo, String marca){ 
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
    }
}
