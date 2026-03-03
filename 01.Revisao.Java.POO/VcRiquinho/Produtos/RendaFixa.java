package VcRiquinho.Produtos;

public class RendaFixa extends ProdutoInvestimento {
    private double rendimentoMensalFixo;
    private int carenciaDias;

    public RendaFixa(String nome, String descricao, double rendimentoMensalFixo, int carenciaDias) {
        super(nome, descricao);
        this.rendimentoMensalFixo = rendimentoMensalFixo;
        this.carenciaDias = carenciaDias;
    }

    @Override
    public double getRendimentoMensal() {
        return rendimentoMensalFixo;
    }

    public int getCarenciaDias() {
        return carenciaDias;
    }
}