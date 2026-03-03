package VcRiquinho.Contas;

import VcRiquinho.Clientes.Cliente;
import VcRiquinho.Produtos.ProdutoInvestimento;
import VcRiquinho.Produtos.RendaFixa;
import java.util.ArrayList;
import java.util.List;

public class ContaInvestimentoAutomatico extends Conta {
    private List<ProdutoInvestimento> produtosVinculados;

    public ContaInvestimentoAutomatico(int numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
        this.produtosVinculados = new ArrayList<>();
    }

    public void vincularProduto(ProdutoInvestimento produto) {
        this.produtosVinculados.add(produto);
    }

    @Override
    public double simularRendimento(int dias, double taxaCdiMensal) {
        if (produtosVinculados.isEmpty()) return 0.0;

        double rendimentoTotal = 0.0;
        // Divide o saldo igualmente entre os produtos vinculados
        double saldoAplicadoPorProduto = this.saldo / produtosVinculados.size();

        for (ProdutoInvestimento p : produtosVinculados) {
            // Verificação de carência para Renda Fixa
            if (p instanceof RendaFixa) {
                RendaFixa rf = (RendaFixa) p;
                if (dias < rf.getCarenciaDias()) {
                    System.out.println("  [AVISO] O produto '" + p.getNome() + "' não gerou rendimentos. Período (" + dias + " dias) inferior à carência (" + rf.getCarenciaDias() + " dias).");
                    continue; 
                }
            }
            double rendimentoDiario = p.getRendimentoMensal() / 30.0;
            rendimentoTotal += saldoAplicadoPorProduto * rendimentoDiario * dias;
        }
        return rendimentoTotal;
    }

    @Override
    public double calcularTaxaServico(double rendimento, Cliente cliente) {
        return rendimento * cliente.getTaxaServicoInvestimento(); // Polimorfismo extraído do cliente
    }
}