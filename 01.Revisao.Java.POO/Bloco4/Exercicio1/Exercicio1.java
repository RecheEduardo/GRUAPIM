package Bloco4.Exercicio1;

import java.util.ArrayList;
import java.util.HashSet;

public class Exercicio1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<Integer>();

        arrInt.add(1);
        arrInt.add(1);
        arrInt.add(2);
        arrInt.add(2);
        arrInt.add(3);
        arrInt.add(3);

        System.out.println("ArrayList: " + arrInt);
        
        HashSet<Integer> arrIntNoDuplicates = new HashSet<Integer>(arrInt);
        System.out.println("Hashset criado com base no ArrayList: " + arrIntNoDuplicates);
    }
}
