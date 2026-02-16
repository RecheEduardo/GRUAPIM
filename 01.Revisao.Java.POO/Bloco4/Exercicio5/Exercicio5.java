package Bloco4.Exercicio5;

import java.util.TreeSet;

public class Exercicio5 {
    public static void main(String[] args) {
        TreeSet<Produto> produtos = new TreeSet<Produto>();

        Produto produto3 = new Produto("Televisao", 3540);
        Produto produto2 = new Produto("Mouse", 146);
        Produto produto1 = new Produto("Cama", 560);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        for (Produto produto : produtos) {
            System.out.println(produto.nome +" - R$" + produto.preco);
        }
    }
}
