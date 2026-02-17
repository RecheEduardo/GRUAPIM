package Bloco6.Exercicio2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<String> pilhaLivros = new ArrayDeque<>();

        String livroParaAdicionar;

        System.out.println("Olá usuário adicione 3 livros a sua pilha!\n");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Diga qual será o livro %d: ", i+1);
            livroParaAdicionar = sc.nextLine();
            pilhaLivros.push(livroParaAdicionar);
        }

        System.out.println("\nSua pilha ficou assim:");
        System.out.println(pilhaLivros);
        
        System.out.println("\nRemovendo o último livro...");
        pilhaLivros.pop();
        System.out.println("Removido! Agora, o primeiro livro da pilha é " + pilhaLivros.peek());
        sc.close();
    }
}
