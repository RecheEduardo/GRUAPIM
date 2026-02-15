package Bloco1;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        int attemptsQtd = 0;
        int numToBeGuessed = (int)(Math.random() * 101);
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá usuário!\nTente advinhar o número aleatório gerado entre 0 e 100:");
        int attemptGuessing = sc.nextInt();
        attemptsQtd++;

        do {
            System.out.printf("\nInfelizmente, NÃO é o número %d\n", attemptGuessing);
            attemptsQtd++;
            
            if(attemptGuessing > numToBeGuessed){
                System.out.println("O seu palpite é MAIOR que o número a ser advinhado\n");
            }
            if(attemptGuessing < numToBeGuessed){
                System.out.println("O seu palpite é MENOR que o número a ser advinhado\n");
            }

            System.out.println("Tente novamente:");
            attemptGuessing = sc.nextInt();

        } while (attemptGuessing != numToBeGuessed);

        System.out.printf("\nParabéns! você acertou o número a ser advinhado: %d!\n", attemptGuessing);
        System.out.printf("Você conseguiu advinhar em: %d tentativas.\n", attemptsQtd);

        sc.close();
    } 


}
