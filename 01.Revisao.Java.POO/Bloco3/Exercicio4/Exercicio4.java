package Bloco3.Exercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> cidades = new ArrayList<String>();

        cidades.add("Oslo");
        cidades.add("Roma");
        cidades.add("Nova Iorque");
        cidades.add("Dubai");
        cidades.add("Rio de Janeiro");
        cidades.add("Pequim");

        System.out.println("Olá usuário, insira o nome de uma cidade e verifique se ela está na lista:");
        String cidade = sc.nextLine();

        do {
            System.out.println("\nCidade não encontrada na lista! Tente novamente:");
            cidade = sc.nextLine();
        } while (!cidades.contains(cidade));

        if(cidades.contains(cidade)){
            System.out.printf("\nEssa cidade está na lista! No índice %d (ou posição %d)", cidades.indexOf(cidade), cidades.indexOf(cidade) + 1);
        }

        sc.close();
    }
}
