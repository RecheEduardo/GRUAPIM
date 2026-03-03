package VcRiquinho.Contas;

import VcRiquinho.Clientes.Cliente;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public double simularRendimento(int dias, double taxaCdiMensal) {
        return 0.0; // Não gera rendimento
    }

    @Override
    public double calcularTaxaServico(double rendimento, Cliente cliente) {
        return 0.0;
    }
}