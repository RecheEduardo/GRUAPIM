package VcRiquinho.Produtos;

public class RendaVariavel extends ProdutoInvestimento {
    private double rendimentoMensalEsperado;

    public RendaVariavel(String nome, String descricao, double rendimentoMensalEsperado) {
        super(nome, descricao);
        this.rendimentoMensalEsperado = rendimentoMensalEsperado;
    }

    @Override
    public double getRendimentoMensal() {
        return rendimentoMensalEsperado;
    }
}