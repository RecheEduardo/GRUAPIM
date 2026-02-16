package Bloco5.Exercicio3;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
    public HashMap<String, String> agenda = new HashMap<String, String>();

    public void exibirAgenda(){
        System.out.println("========= AGENDA DE CONTATOS =========");
        for (Map.Entry<String, String> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();
    }

    public void adicionarContato(String nome, String numero){
        agenda.put(nome, numero);
    }

    public Agenda(String nome, String numero){
        agenda.put(nome, numero);
    }

    public String buscarNumeroPeloNome(String nome){
        return agenda.get(nome);
    }
}
