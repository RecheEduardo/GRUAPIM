package Bloco3.Exercicio1;

import java.util.Scanner;

import Bloco3.Exercicio1.Classes.ListaTarefas;
import Bloco3.Exercicio1.Classes.Tarefa;

public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Olá, seja bem vindo a sua lista de tarefas!\n");
        System.out.println("Insira abaixo a primeira tarefa para iniciar sua lista:");

        // cria a primeira tarefa para inicializar a lista
        Scanner sc = new Scanner(System.in);
        String primeiraTarefa = sc.nextLine();
        ListaTarefas listaTarefas = new ListaTarefas(primeiraTarefa);

        System.out.println();
        listaTarefas.imprimeTarefas();

        int opcao = 0;
        
        do {
            System.out.println("Qual ação você deseja?\n");
            System.out.println("1 - Adicionar Tarefa");
            System.out.println("2 - Remover Tarefa");
            System.out.println("3 - Fechar programa");
            System.out.println();
            
            opcao =  sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                // adicionar tarefa
                case 1:
                    System.out.println("\nDigite abaixo o nome da nova tarefa:");
                    String textoNovaTarefa = sc.nextLine();
                    
                    Tarefa novaTarefa = new Tarefa(textoNovaTarefa);
                    listaTarefas.adicionarTarefa(novaTarefa);

                    System.out.println("\nTarefa ADICIONADA com sucesso!\n");
                    listaTarefas.imprimeTarefas();
                break;

                // remover tarefa
                case 2:
                    System.out.println("\nDigite o índice da tarefa que deseja remover:");
                    int indiceTarefa = sc.nextInt() - 1; // -1 para igualar com índice do array
                    sc.nextLine(); // limpar buffer

                    if(indiceTarefa > listaTarefas.tarefas.size()){
                        System.out.println("\nÍndice inexistente na lista! Voltando...\n");
                        break;
                    }
                    listaTarefas.removerTarefa(indiceTarefa);

                    System.out.println("\nTarefa REMOVIDA com sucesso!\n");
                    listaTarefas.imprimeTarefas();
                break;
                
                // Fechar programa
                case 3:
                    System.out.println("\nFechando...\n");
                break;
            
                // Opção inválida
                default:
                    System.out.println("\nOpção inválida!\n");
                break;
            }
            
        } while (opcao != 3);

        sc.close();
    }

    public static void limparTela() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
