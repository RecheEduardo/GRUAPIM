package Bloco6.Exercicio1;

import java.util.LinkedList;
import java.util.Queue;

public class Exercicio1 {
    public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();
        filaImpressao.add("Documento1.pdf");
        filaImpressao.add("Documento2.png");
        filaImpressao.add("Documento3.jpeg");
        filaImpressao.add("Documento4.html");
        filaImpressao.add("Documento5.webp");

        int tamanhoFilaImpressao = filaImpressao.size();

        for (int i = 0; i < tamanhoFilaImpressao; i++) {
            System.out.println("Documento " + (i+1) + ": " + filaImpressao.poll());
        }

        System.out.println("\nTodos os documentos foram impressos, a fila de impressão está vazia! Veja:");
        System.out.println(filaImpressao);
    }
}
