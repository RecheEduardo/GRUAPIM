import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Olá usuário! Insira um número inteiro");
        int numTaboada = sc.nextInt();
        
        System.out.printf("\nSegue abaixo a tabuada do %d\n", numTaboada);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d X %d = %d\n", numTaboada, i, numTaboada * i);
        }
        
    
        sc.close();
    }   
}