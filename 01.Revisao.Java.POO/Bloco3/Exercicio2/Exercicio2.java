package Bloco3.Exercicio2;

import java.util.ArrayList;
import java.util.Collections;

public class Exercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        for (int i = 0; i < 10; i++) {
            int randomInt = (int)(Math.random() * 10);
            arrList.add(randomInt);
        }

        System.out.println("===== ArrayList ANTES da ordenação =====\n");
        for (int number : arrList) {
            System.out.println(number);
        }
        
        System.out.println();
        System.out.println();

        // Ordenação do ArrayList
        Collections.sort(arrList);

        System.out.println("===== ArrayList APÓS da ordenação =====\n");
        for (int number : arrList) {
            System.out.println(number);
        }
    }   
}
