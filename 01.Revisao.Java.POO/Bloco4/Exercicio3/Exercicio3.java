package Bloco4.Exercicio3;

import java.util.LinkedHashSet;

public class Exercicio3 {
    public static void main(String[] args) {
        LinkedHashSet<String> diasDaSemana = new LinkedHashSet<String>();

        diasDaSemana.add("Quinta");
        diasDaSemana.add("Quarta");
        diasDaSemana.add("Domingo");
        diasDaSemana.add("Segunda");
        diasDaSemana.add("Sábado");
        diasDaSemana.add("Sexta");
        diasDaSemana.add("Terça");

        System.out.println("Dias sendo exibidos conforme ordem de inserção:");
        for (String dia : diasDaSemana) {
            System.out.println(dia);            
        }
    }
}
