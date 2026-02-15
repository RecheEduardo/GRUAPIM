package Bloco1;

public class Exercicio4 {
    public static void main(String[] args) {
        int[] array = {11,2,43,8,23,5,27,18,53};
        int oddNumsSum = 0;
        System.out.println("Array de entrada: ");

        for (int number : array) {
            System.out.printf("%d ", number);
            if(number % 2 != 0){
                oddNumsSum += number;
            }
        }

        System.out.printf("\nA soma dos números ímpares do array é %d", oddNumsSum);
    }
}
