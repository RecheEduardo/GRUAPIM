package VcRiquinho.Contas;

import VcRiquinho.Clientes.Cliente;

public abstract class Conta {
    private int numeroConta;
    protected double saldo;

    public Conta(int numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public int getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) this.saldo += valor;
    }

    public abstract double simularRendimento(int dias, double taxaCdiMensal);
    public abstract double calcularTaxaServico(double rendimento, Cliente cliente);
}