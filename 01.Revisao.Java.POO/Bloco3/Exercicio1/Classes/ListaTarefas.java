package Bloco3.Exercicio1.Classes;

import java.util.ArrayList;

public class ListaTarefas {
    public ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();

    public void adicionarTarefa(Tarefa tarefa){{
        tarefas.add(tarefa);
    }}

    public void removerTarefa(int index){
        tarefas.remove(index);
    }

    public void imprimeTarefas() {
        System.out.println("========= LISTA DE TAREFAS =========\n");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + " - " + tarefas.get(i).tarefa);
        }
        System.out.println("\n====================================\n");

    }

    public ListaTarefas(String primeiraTarefa){
        Tarefa tarefa = new Tarefa(primeiraTarefa);
        this.tarefas.add(tarefa);
    }
}
