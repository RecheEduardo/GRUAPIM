package Lanchonete;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Lanchonete.Classes.Lanche;
import Lanchonete.Classes.Pedido;
import Lanchonete.Classes.Pizza;
import Lanchonete.Classes.Prato;

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
            System.out.println("1 - Lanche");
            System.out.println("2 - Pizza");
            System.out.println("3 - Salgadinho");
            System.out.println("4 - Fechar o programa");
            System.out.println("Insira abaixo o número do prato desejado para adicionar ao pedido!");
            opcao = sc.nextInt();

            switch (opcao) {

                // pedindo lanche
                case 1:
                    System.out.println("Qual tipo de pão você deseja?");
                    String tipoPao = sc.nextLine();

                    System.out.println("Qual tipo de recheio você deseja?");
                    String tipoRecheio = sc.nextLine();
                    
                    int opcaoMolhos = 0;
                    do {
                        System.out.println("Quais molhos você deseja?");
                        ArrayList<String> listaMolhos = new ArrayList<String>();
                        System.out.println("1 - Ketchup");
                        System.out.println("2 - Mostarda");
                        System.out.println("3 - Ketchup & Mostarda");

                        switch (opcaoMolhos) {
                            case 1:
                                listaMolhos.add("Ketchup");
                            break;
                            
                            case 2:
                                listaMolhos.add("Mostarda");
                            break;
                            
                            case 3:
                                listaMolhos.add("Ketchup");
                                listaMolhos.add("Mostarda");
                            break;
                        
                            default:
                                System.out.println("Opção inválida");
                            break;
                        }
                    } while (opcaoMolhos > 0 && opcaoMolhos > 3);


                    Lanche lanche = new Lanche(32.90, LocalDate.parse("2026-06-12"), 323.0, listaMolhos, tipoRecheio, tipoPao);
                    pedido.adicionarPrato(lanche);
                    System.out.println();
                break;

                // pedindo pizza
                case 2:
                    System.out.println("Qual recheio você deseja?");
                    
                    System.out.println("1 - Catupiry");
                    System.out.println("2 - Bacon");
                    System.out.println("3 - Calabresa");
                    String recheio = "";
                    int opcaoRecheio = 0;
                    do {
                        opcaoRecheio = sc.nextInt();
                        switch (opcaoRecheio) {
                            case 1:
                                recheio = "Catupiry";
                            break;
                            
                            case 2:
                                recheio = "Bacon";
                            break;
                            
                            case 3:
                                recheio = "Calabresa";
                            break;
                        
                            default:
                                System.out.println("Opção inválida");
                            break;
                        }
                    } while (opcaoRecheio > 0 && opcaoRecheio > 3);

                    System.out.println("Qual molho você deseja?");
                    
                    System.out.println("1 - Molho de Tomate");
                    System.out.println("2 - Molho Branco");
                    System.out.println("3 - Molho Barbecue");
                    String molho = "";
                    int opcaoMolho = 0;
                    do {
                        opcaoMolho = sc.nextInt();
                        switch (opcaoMolho) {
                            case 1:
                                molho = "Catupiry";
                            break;
                            
                            case 2:
                                molho = "Bacon";
                            break;
                            
                            case 3:
                                molho = "Calabresa";
                            break;
                        
                            default:
                                System.out.println("Opção inválida");
                            break;
                        }
                    } while (opcaoMolho > 0 && opcaoMolho > 3);

                    Boolean bordaRecheada;

                    System.out.println("Para finalizar, você deseja borda rechada?");
                    

                    Pizza pizza = new Pizza(32.90,LocalDate.parse("2026-06-12"),323.0,recheio,true, molho);
                    pedido.adicionarPrato(pizza);
                break;
                
                // pedindo salgadinho
                case 3:
                    System.out.println("");
                break;
                
                case 4:
                    System.out.println("Fechando programa...");
                break;
            
                default:
                    System.out.println("Opção inválida!");
                break;
            }
        } while (opcao != 4);
        
        
        
        sc.close();
    }
}