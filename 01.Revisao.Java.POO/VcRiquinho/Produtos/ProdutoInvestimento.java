package VcRiquinho.Produtos;

public abstract class ProdutoInvestimento {
    private String nome;
    private String descricao;

    public ProdutoInvestimento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    public abstract double getRendimentoMensal();
}