package Bloco5.Exercicio5;

import java.util.Map;
import java.util.TreeMap;

public class Exercicio5 {
    public static void main(String[] args) {
        TreeMap<String, Double> boletins = new TreeMap<String, Double>();

        boletins.put("Nilson", 8.4);
        boletins.put("Marta", 7.6);
        boletins.put("Carlos", 6.8);
        boletins.put("Sarah", 9.6);
        boletins.put("Arthur", 7.1);

        System.out.println("========== ALUNOS EM ORDEM ALFABÉTICA PELO TREEMAP ==========");
        for (Map.Entry<String, Double> aluno : boletins.entrySet()) {
            System.out.println(aluno.getKey() + " - " + aluno.getValue());
        }
    }
}
