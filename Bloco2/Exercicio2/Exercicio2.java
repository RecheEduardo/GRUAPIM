package Bloco2.Exercicio2;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá usuário, adicione um raio em centimetros para criarmos um círculo:");
        double raio = sc.nextDouble();
        
        Circulo circulo = new Circulo(raio);  
        
        sc.close();
    }
}
