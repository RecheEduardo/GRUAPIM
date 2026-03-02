package Lanchonete.Classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String nomeCliente;
    private Double taxaDeServico = 0.0;
    private List<Prato> itensConsumidos;
    private Boolean faturado;
    private Double valorTotal = 0.0;
    private Double troco = 0.0;
    private String metodoDePagamento;

    // getters
    public String getNomeCliente() {
        return nomeCliente;
    }
    public Double getTaxaDeServico() {
        return taxaDeServico;
    }
    public List<Prato> getItensConsumidos() {
        return itensConsumidos;
    }
    public Boolean getFaturado() {
        return faturado;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public Double getTroco() {
        return troco;
    }
    public String getMetodoDePagamento() {
        return metodoDePagamento;
    }

    // setters
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setTaxaDeServico(Double taxaDeServico) {
        this.taxaDeServico = taxaDeServico;
    }
    public void setItensConsumidos(List<Prato> itensConsumidos) {
        this.itensConsumidos = itensConsumidos;
    }
    public void setFaturado(Boolean faturado) {
        this.faturado = faturado;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setTroco(Double troco) {
        this.troco = troco;
    }
    public void setMetodoDePagamento(String metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    public Pedido(String nomeCliente, ArrayList<Prato> itensConsumidos) {
        this.nomeCliente = nomeCliente;
        this.itensConsumidos = itensConsumidos;
    }

    public void calcularTotal(){
        Double total = 0.0;
        for (Prato prato : itensConsumidos) {
            total += prato.getPrecoDeVenda();
        }
        setValorTotal(total);
        setTaxaDeServico(total * 0.1);
    }

    public void mostrarFatura(){
        calcularTotal();
        System.out.println("====== Dados do pedido ======");
        System.out.println("=== Cliente: " + this.getNomeCliente());
        System.out.println("====== Pratos consumidos: ");
        for (Prato prato : this.itensConsumidos) {
            
            System.out.println("=== " + prato.getClass().getTypeName() + " - R$ " + prato.getPrecoDeVenda());
            
            if (prato.getClass() == Pizza.class) {
                Pizza pizza = (Pizza) prato;
                String bordaRecheada = pizza.getBordaRecheada() ? "Sim" : "Não";
                System.out.println("- Recheio: " + pizza.getRecheio());
                System.out.println("- Borda recheada?: " + bordaRecheada);
                System.out.println("- Molho: " + pizza.getMolho());
            }

            if (prato.getClass() == Lanche.class) {
                Lanche lanche = (Lanche) prato;
                System.out.println("- Tipo de pão: " + lanche.getTipoDePao());
                System.out.println("- Recheio: " + lanche.getRecheio());
                System.out.print("- Molhos: ");
                for (String molho : lanche.getMolhos()) {
                    System.out.print(molho + " ");
                }
            }

            if (prato.getClass() == Salgadinho.class) {
                Salgadinho salgadinho = (Salgadinho) prato;
                System.out.println("- Tipo: " + salgadinho.getTipo());
                System.out.println("- Massa: " + salgadinho.getMassa());
                System.out.println("- Recheio: " + salgadinho.getRecheio());
            }
            System.out.println("- Peso: " + prato.getPeso());
        }
        System.out.println("======= Taxa de serviço: " + this.getTaxaDeServico());
        System.out.println("======= Valor total: " + this.getValorTotal());
    }

    public void adicionarPrato(Prato novoPrato){
        this.itensConsumidos.add(novoPrato);
    }
}
