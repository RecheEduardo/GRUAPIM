package Bloco5.Exercicio1;

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dicionario = new HashMap<String, String>();

        dicionario.put("Porta", "Door");
        dicionario.put("Mesa", "Table");
        dicionario.put("Janela", "Window");
        dicionario.put("Cabeça", "Head");

        String palavra;

        do {
            System.out.println("Olá usuário, insira abaixo uma palavra do dicionário para ver sua tradução:");
            palavra = sc.nextLine();

            if (!dicionario.containsKey(palavra)) {
                System.out.println("Palavra não encontrada no dicionário, tente outra!");
            }

        } while (!dicionario.containsKey(palavra));

        System.out.println("Palavra encontrada no dicionário! Sua tradução em inglês é "  + dicionario.get(palavra) + "!");

        sc.close();
    }
}
