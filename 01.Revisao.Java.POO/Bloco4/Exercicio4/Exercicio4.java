package Bloco4.Exercicio4;

import java.util.TreeSet;

public class Exercicio4 {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<String>();

        names.add("Daniel");
        names.add("Carlos");
        names.add("Bruna");
        names.add("Antonio");

        // Nomes sendo impressos em ordem alfabetica independente ordem de inserção
        for (String name : names) {
            System.out.println(name);
        }
    }
}
