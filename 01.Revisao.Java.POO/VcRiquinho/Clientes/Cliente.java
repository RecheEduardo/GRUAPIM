package VcRiquinho.Clientes;

import VcRiquinho.Contas.Conta;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nome;
    private String email;
    private List<Conta> contas;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.contas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public List<Conta> getContas() { return contas; }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    // Método polimórfico para buscar a taxa base de investimento do cliente
    public abstract double getTaxaServicoInvestimento();
}