package Lanchonete;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Lanchonete.Classes.Lanche;
import Lanchonete.Classes.Pedido;
import Lanchonete.Classes.Pizza;
import Lanchonete.Classes.Prato;
import Lanchonete.Classes.Salgadinho;

public class Lanchonete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Olá usuário, faça seu primeiro pedido!");
        System.out.println("Primeiramente, digite seu nome:");
        String nomeCliente = sc.nextLine();
        
        ArrayList<Prato> listaPratos = new ArrayList<Prato>();
        Pedido pedido = new Pedido(nomeCliente, listaPratos);

        System.out.println("Olá " + nomeCliente + ". Segue o cardápio abaixo:");
        System.out.println("");
        int opcao = 0;
        
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Lanche");
            System.out.println("2 - Pizza");
            System.out.println("3 - Salgadinho");
            System.out.println("4 - Fechar pedido e gerar fatura");
            System.out.println("Insira abaixo o número do prato desejado para adicionar ao pedido!");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar o buffer do scanner

            switch (opcao) {

                // Pedindo lanche
                case 1:
                    System.out.println("\n----- CARDÁPIO DE LANCHES -----");
                    System.out.println("1 - X-Burger (Pão brioche, hambúrguer bovino, ketchup e mostarda) - R$ 22,00");
                    System.out.println("2 - X-Bacon (Pão australiano, hambúrguer com bacon, maionese e barbecue) - R$ 28,00");
                    System.out.println("3 - X-Frango (Pão integral, frango grelhado, maionese e salada) - R$ 25,00");
                    System.out.print("Escolha uma opção: ");
                    int opcaoLanche = sc.nextInt();
                    sc.nextLine();

                    String tipoPao = null, tipoRecheio = null;
                    ArrayList<String> listaMolhos = new ArrayList<String>();
                    double precoLanche = 0, pesoLanche = 350.0;

                    switch (opcaoLanche) {
                        case 1:
                            tipoPao = "Brioche";
                            tipoRecheio = "Hambúrguer Bovino";
                            listaMolhos.add("Ketchup");
                            listaMolhos.add("Mostarda");
                            precoLanche = 22.00;
                            break;
                        case 2:
                            tipoPao = "Australiano";
                            tipoRecheio = "Hambúrguer com Bacon";
                            listaMolhos.add("Maionese");
                            listaMolhos.add("Barbecue");
                            precoLanche = 28.00;
                            break;
                        case 3:
                            tipoPao = "Integral";
                            tipoRecheio = "Frango Grelhado";
                            listaMolhos.add("Maionese");
                            listaMolhos.add("Salada");
                            precoLanche = 25.00;
                            break;
                        default:
                            System.out.println("Opção inválida! Nenhum lanche adicionado.");
                            break;
                    }

                    if (opcaoLanche >= 1 && opcaoLanche <= 3) {
                        Lanche lanche = new Lanche(precoLanche, LocalDate.now().plusDays(3), pesoLanche, listaMolhos, tipoRecheio, tipoPao);
                        pedido.adicionarPrato(lanche);
                        System.out.println("Lanche adicionado ao pedido!\n");
                    }
                break;

                // Pedindo pizza
                case 2:
                    System.out.println("\n----- CARDÁPIO DE PIZZAS -----");
                    System.out.println("1 - Margherita (Molho de tomate, mussarela, tomate e manjericão) - R$ 40,00");
                    System.out.println("2 - Calabresa (Molho de tomate, calabresa e cebola) - R$ 42,00");
                    System.out.println("3 - Quatro Queijos (Molho branco, mussarela, parmesão, gorgonzola e catupiry) - R$ 48,00");
                    System.out.print("Escolha uma opção: ");
                    int opcaoPizza = sc.nextInt();
                    sc.nextLine();

                    String recheioPizza = null, molhoPizza = null;
                    double precoPizza = 0, pesoPizza = 800.0;
                    Boolean bordaRecheada = false;

                    System.out.println("Você deseja borda recheada? (1 - Sim / 2 - Não)");
                    int opcaoBorda = sc.nextInt();
                    bordaRecheada = (opcaoBorda == 1);
                    sc.nextLine();

                    switch (opcaoPizza) {
                        case 1:
                            recheioPizza = "Mussarela, Tomate e Manjericão";
                            molhoPizza = "Molho de Tomate";
                            precoPizza = 40.00;
                            break;
                        case 2:
                            recheioPizza = "Calabresa e Cebola";
                            molhoPizza = "Molho de Tomate";
                            precoPizza = 42.00;
                            break;
                        case 3:
                            recheioPizza = "Mussarela, Parmesão, Gorgonzola e Catupiry";
                            molhoPizza = "Molho Branco";
                            precoPizza = 48.00;
                            break;
                        default:
                            System.out.println("Opção inválida! Nenhuma pizza adicionada.");
                            break;
                    }

                    if (opcaoPizza >= 1 && opcaoPizza <= 3) {
                        Pizza pizza = new Pizza(precoPizza, LocalDate.now().plusDays(3), pesoPizza, recheioPizza, bordaRecheada, molhoPizza);
                        pedido.adicionarPrato(pizza);
                        System.out.println("Pizza adicionada ao pedido!\n");
                    }
                break;
                
                // Pedindo salgadinho
                case 3:
                    System.out.println("\n----- CARDÁPIO DE SALGADINHOS -----");
                    System.out.println("1 - Coxinha (Massa de batata, frango desfiado, frito) - R$ 7,00");
                    System.out.println("2 - Pastel de Carne (Massa de pastel, carne moída, frito) - R$ 8,00");
                    System.out.println("3 - Empada de Palmito (Massa folhada, palmito, assado) - R$ 9,00");
                    System.out.print("Escolha uma opção: ");
                    int opcaoSalgadinho = sc.nextInt();
                    sc.nextLine();

                    String tipoSalgadinho = null, massaSalgadinho = null, recheioSalgadinho = null;
                    double precoSalgadinho = 0, pesoSalgadinho = 120.0;

                    switch (opcaoSalgadinho) {
                        case 1:
                            tipoSalgadinho = "Frito";
                            massaSalgadinho = "Massa de Batata";
                            recheioSalgadinho = "Frango Desfiado";
                            precoSalgadinho = 7.00;
                            break;
                        case 2:
                            tipoSalgadinho = "Frito";
                            massaSalgadinho = "Massa de Pastel";
                            recheioSalgadinho = "Carne Moída";
                            precoSalgadinho = 8.00;
                            break;
                        case 3:
                            tipoSalgadinho = "Assado";
                            massaSalgadinho = "Massa Folhada";
                            recheioSalgadinho = "Palmito";
                            precoSalgadinho = 9.00;
                            break;
                        default:
                            System.out.println("Opção inválida! Nenhum salgadinho adicionado.");
                            break;
                    }

                    if (opcaoSalgadinho >= 1 && opcaoSalgadinho <= 3) {
                        Salgadinho salgadinho = new Salgadinho(precoSalgadinho, LocalDate.now().plusDays(3), pesoSalgadinho);
                        salgadinho.setTipo(tipoSalgadinho);
                        salgadinho.setMassa(massaSalgadinho);
                        salgadinho.setRecheio(recheioSalgadinho);
                        pedido.adicionarPrato(salgadinho);
                        System.out.println("Salgadinho adicionado ao pedido!\n");
                    }
                break;
                
                // Finalizando o programa / Faturamento
                case 4:
                    System.out.println("\nFechando programa e processando o pedido...\n");
                    pedido.mostrarFatura(); // Imprime a nota fiscal na tela
                    
                    Double totalPagar = pedido.getValorTotal() + pedido.getTaxaDeServico();
                    System.out.printf("\nO valor total (Pratos + Serviço) é: R$ %.2f\n", totalPagar);
                    
                    System.out.println("Insira o valor recebido em dinheiro pelo cliente: ");
                    Double valorRecebido = sc.nextDouble();
                    
                    if (valorRecebido >= totalPagar) {
                        Double troco = valorRecebido - totalPagar;
                        pedido.setTroco(troco);
                        System.out.printf("Pagamento efetuado com sucesso! O troco do cliente é: R$ %.2f\n", troco);
                    } else {
                        System.out.println("Atenção: O valor recebido é menor do que o total da fatura. Pagamento pendente.");
                    }
                break;
            
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                break;
            }
        } while (opcao != 4);
        
        sc.close();
    }
}