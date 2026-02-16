package Bloco5.Exercicio2;

import java.util.HashMap;
import java.util.Map;

public class Exercicio2 {
    public static void main(String[] args) {
        HashMap<String, Integer> contadorPalavras = new HashMap<String, Integer>();
        
        String paragrafo = "a disciplina é algo que eu valorizo muito, porque a disciplina constrói resultados e resultados constroem confiança. Quando existe foco, o foco direciona a energia, e essa energia gera progresso, progresso constante, progresso real. Nem todo dia é motivação, mas a motivação ajuda; o que realmente sustenta é a disciplina, disciplina diária, disciplina silenciosa.";
        // limpando os caracteres do pagrafos e gerando um array de palavras dele
        paragrafo = paragrafo.replaceAll("[.,;]", "");
        String[] palavras = paragrafo.split(" ");

        // a cada palavra repetida ele adiciona 1 no value, se for nova, adiciona com zero (primeira ocorrencia)
        for (String palavra : palavras) {
            contadorPalavras.put(palavra, contadorPalavras.getOrDefault(palavra, 0) + 1);
        }

        // transforma as entries do hashmap em um set, facilitando na iteração pra ver melhor
        System.out.println("========= CONTADOR DE PALAVRAS =========");
        for (Map.Entry<String, Integer> entry : contadorPalavras.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() +  " OCORRÊNCIAS");
        }

    }
}
