package Bloco7.Exercicio1;

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

    public String toString(){
        return this.nome + " - R$" + this.preco;
    }
}
