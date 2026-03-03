package VcRiquinho.Clientes;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    public String getCnpj() { return cnpj; }

    @Override
    public double getTaxaServicoInvestimento() {
        return 0.0015; // 0.15%
    }
}