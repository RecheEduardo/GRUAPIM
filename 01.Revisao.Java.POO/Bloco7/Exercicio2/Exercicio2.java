package Bloco7.Exercicio2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Exercicio2 {
    public static void main(String[] args) {
        List<String> participantes = new ArrayList<String>();

        participantes.add("Carlos");
        participantes.add("Roberta");
        participantes.add("Maria");
        participantes.add("Carlos");
        participantes.add("João");
        participantes.add("Eduardo");
        participantes.add("Jonas");
        participantes.add("João");
        participantes.add("Eduardo");
        participantes.add("Maria");

        System.out.println("Lista de participantes do sorteio:\n");
        for (String participante : participantes) {
            System.out.println(participante);            
        }

        sortear(participantes);
    }
    
    public static void sortear(List<String> participantes){
        // converte para set para não ter repetições
        Set<String> participantesSemRepeticao = new HashSet<>(participantes);

        System.out.println("\nLista de participantes do sorteio SEM REPETIÇÕES:\n");
        for (String participante : participantesSemRepeticao) {
            System.out.println(participante);
        }
        System.out.println("");

        // reconvertendo para lista para acessar índice aleatorio
        List<String> listaSemRepeticoes = new ArrayList<>(participantesSemRepeticao);
        
        Random random = new Random();
        int indiceRandom;
        String participanteSorteado;

        // iterando sobre os 3 ganhadores do sorteio, removendo o ganhador da proxima iteração
        for (int i = 0; i < 3; i++) {
            indiceRandom = random.nextInt(listaSemRepeticoes.size());
            participanteSorteado = listaSemRepeticoes.get(indiceRandom);
            System.out.println((i+1) + "° Ganhador(a) = " + participanteSorteado);
            listaSemRepeticoes.remove(indiceRandom);
        }
    }
}
