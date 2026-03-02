package Lanchonete.Classes;

import java.time.LocalDate;

public class Prato {
    private Double precoDeVenda;
    private LocalDate dataValidade;
    private Double peso;

    // getters
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    public Double getPeso() {
        return peso;
    }
    public Double getPrecoDeVenda() {
        return precoDeVenda;
    }

    // setters
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public void setPrecoDeVenda(Double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public Prato(Double precoDeVenda, LocalDate dataValidade, Double peso){
        this.precoDeVenda = precoDeVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }
}
