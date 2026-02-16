package Bloco3.Exercicio3;

import java.util.LinkedList;

public class Exercicio3 {
    public static void main(String[] args) {
        LinkedList<String> filaAtendimento = new LinkedList<String>();
        
        // Criando fila de atendimento com 5 clientes:
        filaAtendimento.add("Roberto");
        filaAtendimento.add("Maria");
        filaAtendimento.add("Laura");
        filaAtendimento.add("Joao");
        filaAtendimento.add("Pedro");

        System.out.println("===== Criando fila: =====\n");
        for (String cliente : filaAtendimento) {
            System.out.println(cliente);
        }

        System.out.println();

        // "Atendendo" os 2 primeiros clientes
        filaAtendimento.removeFirst();
        filaAtendimento.removeFirst();

        System.out.println("===== Fila após 2 atendimentos: =====\n");
        for (String cliente : filaAtendimento) {
            System.out.println(cliente);
        }

        System.out.println();

        // 2 clientes prioritários chegaram ao atendimento:
        filaAtendimento.addFirst("Jorge");
        filaAtendimento.addFirst("Luis");

        System.out.println("===== Fila após 2 clientes prioritários chegarem: =====\n");
        for (String cliente : filaAtendimento) {
            System.out.println(cliente);
        }
    }
}
