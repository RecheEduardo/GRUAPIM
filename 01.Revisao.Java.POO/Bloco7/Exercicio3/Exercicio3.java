package Bloco7.Exercicio3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> pilhaFrases = new ArrayDeque<String>();

        System.out.println("Olá usuário! Digite uma frase:");
        String fraseInput = sc.nextLine();

        String[] palavrasFraseInput = fraseInput.split(" ");
        
        for (String palavra : palavrasFraseInput) {
            pilhaFrases.push(palavra);
        }
        
        int qtdPalavrasFrase = pilhaFrases.size();

        for (int i = 0; i < qtdPalavrasFrase; i++) {
            System.out.printf("%s ", pilhaFrases.pollFirst());
        }

        sc.close();
    }   
}
