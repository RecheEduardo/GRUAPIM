public class Exercicio1 {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Produto 1", 10.0, "Eletrônicos"));
        produtos.add(new Produto("Produto 2", 200.0, "Roupas"));
        produtos.add(new Produto("Produto 3", 300.0, "Livros"));
        produtos.add(new Produto("Produto 4", 40.0, "Bebidas"));
        produtos.add(new Produto("Produto 5", 500.0, "Automóveis"));
        produtos.add(new Produto("Produto 6", 60.0, "Roupas"));
        produtos.add(new Produto("Produto 7", 700.0, "Livros"));
        produtos.add(new Produto("Produto 8", 800.0, "Eletrônicos"));


        // EXERCICIO A
        // utilizando foreach com if para filtrar os produtos de uma categoria específica
        for (Produto produto : produtos) {
            if (produto.getCategoria().equals("Eletrônicos")) {
                System.out.println(produto.getNome() + " - " + produto.getPreco() + " - " + produto.getCategoria());
            }
        }

        // utilizando stream para filtrar os produtos de uma categoria específica
        produtos.stream().filter(produto -> produto.getCategoria().equals("Eletrônicos"))
        .forEach(produto -> 
            System.out.println(produto.getNome() + " - " + produto.getPreco() + " - " + produto.getCategoria())
        );
        System.out.println("--------------------------------");


        // EXERCICIO B
        List<Produto> produtosMaisCarosQue500 = produtos.stream().filter(produto -> produto.getPreco() > 500).toList();

        for (Produto produto : produtosMaisCarosQue500) {
            System.out.println(produto.getNome() + " - " + produto.getPreco() + " - " + produto.getCategoria());
        }
        produtosMaisCarosQue500.stream().forEach(produto -> 
            System.out.println(produto.getNome() + " - " + produto.getPreco() + " - " + produto.getCategoria())
        );
        System.out.println("--------------------------------");


        // EXERCICIO C
        double valorTotalEstoqueLivros = produtos.stream()
        .filter(produto -> produto.getCategoria().equals("Livros"))
        .mapToDouble(produto -> produto.getPreco())
        .sum();
        
        System.out.println("O valor total do estoque de produtos da categoria “Livros” é: " + valorTotalEstoqueLivros);
        System.out.println("--------------------------------");


        // EXERCICIO E
        Optional<Produto> produtoEncontrado = buscarProdutoPorNome(produtos, "Produto 1");
        if (produtoEncontrado.isPresent()) {
            System.out.println("Produto encontrado: " + produtoEncontrado.get().getNome() + " - " + produtoEncontrado.get().getPreco() + " - " + produtoEncontrado.get().getCategoria());
        } else {
            System.out.println("Produto não encontrado");
        }

        Produto produtoEncontradoOuExcecao = buscarProdutoPorNome(produtos, "Produto 9")
            .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        System.out.println("Produto encontrado: " + produtoEncontradoOuExcecao.getNome() + " - " + produtoEncontradoOuExcecao.getPreco() + " - " + produtoEncontradoOuExcecao.getCategoria());
        System.out.println("--------------------------------");


        // EXERCICIO F
        List<String> nomesProdutos = produtos.stream()
        .map(produto -> produto.getNome())
        .toList();
        System.out.println("Nomes dos produtos: " + nomesProdutos);

        List<String> nomesProdutosReferenciaMetodo = produtos.stream()
        .map(Produto::getNome)
        .toList();
        System.out.println("Nomes dos produtos: " + nomesProdutosReferenciaMetodo);
    }

    // EXERCICIO D
    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
        .filter(produto -> produto.getNome().equals(nome))
        .findFirst();
    }
}
