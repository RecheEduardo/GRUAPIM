package Bloco8.Exercicio1;

public class Produto {
    private int codigo;
    public String nome;
    protected double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    private double calcularImposto() {
        return preco * 0.1;
    }
}
