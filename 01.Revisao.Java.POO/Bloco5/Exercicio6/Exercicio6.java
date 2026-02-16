package Bloco5.Exercicio6;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá usuário! Insira o primeiro contato da sua agenda abaixo para inicializar ela:");
        String primeiroNome = sc.nextLine();

        System.out.println("\nPerfeito, agora digite o número de "+ primeiroNome +" abaixo");
        String primeiroTelefone = sc.nextLine();

        Agenda agenda = new Agenda(primeiroNome, primeiroTelefone);

        System.out.println();

        int opcao = 0;
        
        do {
            System.out.println("Qual ação você deseja?\n");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Buscar Número pelo nome do contato");
            System.out.println("3 - Listar todos os contatos");
            System.out.println("4 - Verificar se existe nome na agenda");
            System.out.println("5 - Verificar se existe número na agenda");
            System.out.println("6 - Fechar programa");
            System.out.println();
            
            opcao =  sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                // adicionar contato
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String novoNome = sc.nextLine();

                    System.out.println("\nPerfeito, agora digite o número de "+ novoNome +" abaixo:");
                    String novoTelefone = sc.nextLine();

                    agenda.adicionarContato(novoNome, novoTelefone);

                    System.out.println("\nContato adicionado!\n");
                break;

                // buscar número pelo nome
                case 2:
                    System.out.println("\nDigite o nome do contato que deseja consultar o número:");
                    
                    String nomeBusca = sc.nextLine();
                    String numeroBusca = agenda.buscarNumeroPeloNome(nomeBusca);
                    
                    if(numeroBusca == null){
                        System.out.println("\nInfelizmente não existe esse contato na lista...\n");
                    } else {
                        System.out.println("\nEncontrado! O numero de " + nomeBusca + " é " + numeroBusca + "!\n");
                    }
                break;
                
                // Exibir a lista de contatos
                case 3:
                    System.out.println("\nExibindo a lista de contatos:\n");
                    agenda.exibirAgenda();
                break;
                
                // Verificar se existe na nome agenda
                case 4:
                    System.out.println("\nEscreva o nome para verificar se existe na agenda:\n");
                    String nomeBuscaExistencia = sc.nextLine();
                    
                    Boolean existeNome = agenda.existeNomeNaAgenda(nomeBuscaExistencia);
                    if(!existeNome){
                        System.out.println("\nO nome " + nomeBuscaExistencia + " NÃO existe na agenda.\n");
                    } else {
                        System.out.println("\nO nome " + nomeBuscaExistencia + " EXISTE na agenda!\n");
                    }
                break;
                
                // Verificar se existe número na agenda
                case 5:
                    System.out.println("\nEscreva o número para verificar se existe na agenda:\n");
                    String numeroBuscaExistencia = sc.nextLine();
                    
                    Boolean existeNumero = agenda.existeNumeroNaAgenda(numeroBuscaExistencia);
                    if(!existeNumero){
                        System.out.println("\nO número " + numeroBuscaExistencia + " NÃO existe na agenda.\n");
                    } else {
                        System.out.println("\nO número " + numeroBuscaExistencia + " EXISTE na agenda!\n");
                    }
                break;
                
                // Fechar programa
                case 6:
                    System.out.println("\nFechando programa...\n");
                break;
            
                // Opção inválida
                default:
                    System.out.println("\nOpção inválida!\n");
                break;
            }
            
        } while (opcao != 6);

        sc.close();
    }

    
}
