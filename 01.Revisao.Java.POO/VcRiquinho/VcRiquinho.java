package VcRiquinho;

import VcRiquinho.Contas.ContaInvestimentoAutomatico;
import VcRiquinho.Clientes.*;
import VcRiquinho.Contas.*;
import VcRiquinho.Produtos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VcRiquinho {
    private static List<Cliente> bancoClientes = new ArrayList<>();
    private static List<ProdutoInvestimento> bancoProdutos = new ArrayList<>();
    private static int geradorNumeroConta = 1000;
    
    private static final double TAXA_CDI_MENSAL = 0.01; 

    public static void main(String[] args) {
        bancoProdutos.add(new RendaFixa("Tesouro Selic", "Títulos do governo", 0.008, 0));
        bancoProdutos.add(new RendaFixa("LCI Banco X", "Letra de crédito", 0.009, 90));
        bancoProdutos.add(new RendaVariavel("Fundo Imobiliário ABC", "FII Galpões", 0.012));

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n==== VcRiquinho - Painel Administrativo ====");
            System.out.println("1. Cadastrar Cliente (PF ou PJ)");
            System.out.println("2. Cadastrar Produto de Investimento");
            System.out.println("3. Simular Rendimentos e Taxas (30, 60, 90, 180 dias)");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(sc);
                    break;
                case 2:
                    cadastrarProduto(sc);
                    break;
                case 3:
                    simularInvestimentos(sc);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        } while (opcao != 4);
        
        sc.close();
    }

    private static void cadastrarCliente(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Tipo (1 - PF / 2 - PJ): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Cliente novoCliente = null;
        if (tipo == 1) {
            System.out.print("CPF: ");
            String cpf = sc.nextLine();
            novoCliente = new ClientePF(nome, email, cpf);
        } else {
            System.out.print("CNPJ: ");
            String cnpj = sc.nextLine();
            novoCliente = new ClientePJ(nome, email, cnpj);
        }

        System.out.print("Saldo inicial da conta padrão: R$ ");
        double saldo = sc.nextDouble();
        
        System.out.println("Tipos de conta: 1-Corrente | 2-CDI | 3-Investimento Automático");
        System.out.print("Escolha: ");
        int tipoConta = sc.nextInt();
        sc.nextLine();
        
        Conta novaConta = null;
        if(tipoConta == 1) novaConta = new ContaCorrente(geradorNumeroConta++, saldo);
        else if(tipoConta == 2) novaConta = new ContaCDI(geradorNumeroConta++, saldo);
        else {
            ContaInvestimentoAutomatico contaInv = new ContaInvestimentoAutomatico(geradorNumeroConta++, saldo);

            for (ProdutoInvestimento p : bancoProdutos) {
                contaInv.vincularProduto(p);
            }
            novaConta = contaInv;
        }

        novoCliente.adicionarConta(novaConta);
        bancoClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso! Conta nº: " + novaConta.getNumeroConta());
    }

    private static void cadastrarProduto(Scanner sc) {
        System.out.print("Nome do Produto: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Tipo (1 - Renda Fixa / 2 - Renda Variável): ");
        int tipo = sc.nextInt();
        
        if (tipo == 1) {
            System.out.print("Rendimento Fixo Mensal (Ex: 0,01 para 1%): ");
            double rend = sc.nextDouble();
            System.out.print("Carência em dias: ");
            int carencia = sc.nextInt();
            bancoProdutos.add(new RendaFixa(nome, desc, rend, carencia));
        } else {
            System.out.print("Rendimento Esperado Mensal (Ex: 0,02 para 2%): ");
            double rend = sc.nextDouble();
            bancoProdutos.add(new RendaVariavel(nome, desc, rend));
        }
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void simularInvestimentos(Scanner sc) {
        if (bancoClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Escolha o período da simulação:");
        System.out.println("1 - 30 dias | 2 - 60 dias | 3 - 90 dias | 4 - 180 dias");
        int opDias = sc.nextInt();
        int dias = 30;
        if(opDias == 2) dias = 60;
        else if(opDias == 3) dias = 90;
        else if(opDias == 4) dias = 180;

        System.out.println("\n--- RESULTADO DA SIMULAÇÃO (" + dias + " DIAS) ---");
        for (Cliente c : bancoClientes) {
            System.out.println("Cliente: " + c.getNome() + " | Tipo: " + c.getClass().getSimpleName());
            for (Conta conta : c.getContas()) {
                System.out.println("  Conta: " + conta.getClass().getSimpleName() + " (Nº " + conta.getNumeroConta() + ") | Saldo Base: R$ " + conta.getSaldo());
                
                double rendimentoBruto = conta.simularRendimento(dias, TAXA_CDI_MENSAL);
                double taxaServico = conta.calcularTaxaServico(rendimentoBruto, c);
                
                System.out.printf("  -> Rendimento Bruto: R$ %.2f\n", rendimentoBruto);
                System.out.printf("  -> Taxa de Serviço VcRiquinho: R$ %.2f\n", taxaServico);
                System.out.printf("  -> Rendimento Líquido: R$ %.2f\n", (rendimentoBruto - taxaServico));
                System.out.println("  --------------------------------------");
            }
        }
    }
}