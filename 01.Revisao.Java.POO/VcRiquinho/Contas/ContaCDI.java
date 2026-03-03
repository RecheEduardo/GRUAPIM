package VcRiquinho.Contas;

import VcRiquinho.Clientes.Cliente;

public class ContaCDI extends Conta {

    public ContaCDI(int numeroConta, double saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public double simularRendimento(int dias, double taxaCdiMensal) {
        // Rende 1/30 do CDI diariamente
        double cdiDiario = taxaCdiMensal / 30.0;
        return this.saldo * cdiDiario * dias; 
    }

    @Override
    public double calcularTaxaServico(double rendimento, Cliente cliente) {
        return rendimento * 0.0007; // 0.07% fixo
    }
}