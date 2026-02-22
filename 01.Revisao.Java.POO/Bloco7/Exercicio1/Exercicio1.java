package Bloco7.Exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Produto>> catalogo = new HashMap<>();

        System.out.println("Criando categorias do catálogo...");

        // Criei sem acento o nome das categorias pois estava com
        // problema no encoding no terminal para ler o input do usuário
        catalogo.put("Eletrodomesticos", new ArrayList<>());
        catalogo.put("Cozinha", new ArrayList<>());
        catalogo.put("Informatica", new ArrayList<>());
        
        System.out.println("Criando produtos para cada categoria...\n");

        catalogo.get("Eletrodomesticos").add(new Produto("Aspirador de pó", 350));
        catalogo.get("Eletrodomesticos").add(new Produto("Máquina de lavar", 3200));
        catalogo.get("Eletrodomesticos").add(new Produto("Lava Louças", 1900));

        catalogo.get("Cozinha").add(new Produto("Jogo de pratos", 450));
        catalogo.get("Cozinha").add(new Produto("Microondas", 420));
        catalogo.get("Cozinha").add(new Produto("Air Fryer", 540));
        
        catalogo.get("Informatica").add(new Produto("GTX 1080 TI", 1200));
        catalogo.get("Informatica").add(new Produto("Fonte 800W 80 Plus", 700));
        catalogo.get("Informatica").add(new Produto("I5 12400F", 610));
        
        String opcaoCategoria;
        do {
            System.out.println("Bem vindo ao catálogo de produtos!\n");
            for (Entry<String, List<Produto>> produto : catalogo.entrySet()) {
                System.out.println(produto.getKey());
            }
            System.out.println("\nPara fechar o programa, digite 'X'.");
            System.out.println("Digite o nome da categoria para ver seus respectivos produtos:\n");
            
            opcaoCategoria =  sc.nextLine();

            if(opcaoCategoria.equals("X")){
                System.out.println("Fechando programa...");
            } 
            
            else if (catalogo.containsKey(opcaoCategoria)){
                System.out.println("\nProdutos da categoria " + opcaoCategoria + ":\n");

                List<Produto> produtosDaCategoria = catalogo.get(opcaoCategoria);
                for (Produto produto : produtosDaCategoria) {
                    System.out.println(produto.toString());
                };

                System.out.println();
            }

            else{
                System.out.println("\nOpção inválida!\n");
            }
            
        } while (!opcaoCategoria.equals("X"));

        sc.close();
    }
}
