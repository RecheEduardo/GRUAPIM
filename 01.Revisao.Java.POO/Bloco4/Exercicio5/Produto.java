package Bloco4.Exercicio5;

public class Produto implements Comparable<Produto> {
    public String nome;
    public double preco;

    public int compareTo(Produto produto) {
        return Double.compare(this.preco, produto.preco);
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
