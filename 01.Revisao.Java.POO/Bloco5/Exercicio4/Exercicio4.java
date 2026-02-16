package Bloco5.Exercicio4;

import java.util.LinkedHashMap;
import java.util.Map;

public class Exercicio4 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> armazem = new LinkedHashMap<Integer, String>();
        armazem.put(84, "Calça Jeans Azul");
        armazem.put(712, "Gabinete Gamer");
        armazem.put(75, "Boneco Funko Pop");
        armazem.put(39, "Quadro Renascentista");
        armazem.put(346, "Jogo de PS5");

        System.out.println("====== Ordem de cadastro se manteve: ======");
        for (Map.Entry<Integer, String> produto : armazem.entrySet()) {
            System.out.println(produto.getKey() + " - " + produto.getValue());           
        }
    }
}
