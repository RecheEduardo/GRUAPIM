import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Olá aluno! Insira a primeira nota:");
        double nota1 = sc.nextDouble();
        
        System.out.println("Perfeito, agora insira a segunda nota:");
        double nota2 = sc.nextDouble();
        
        System.out.println("Por último, insira a terceira nota:");
        double nota3 = sc.nextDouble();

        double media = (nota1 + nota2 + nota3)/3;
        System.out.printf("Sua nota é %.2f\n\n", media);

        if (media >= 7){
            System.out.println("Parabéns, você passou!");
        } else {
            System.out.println("Infelizmente você não passou.");
        }
    
        sc.close();
    }   
}