package Lanchonete.Classes;

import java.time.LocalDate;

public class Pizza extends Prato {

    private String recheio;
    private Boolean bordaRecheada;
    private String molho;

    public String getRecheio() {
        return recheio;
    }
    public Boolean getBordaRecheada() {
        return bordaRecheada;
    }
    public String getMolho() {
        return molho;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    public void setBordaRecheada(Boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }
    public void setMolho(String molho) {
        this.molho = molho;
    }

    public Pizza(Double precoDeVenda, LocalDate dataValidade, Double peso, 
        String recheio, Boolean bordaRecheada, String molho) {
        super(precoDeVenda, dataValidade, peso);
        this.recheio = recheio;
        this.bordaRecheada = bordaRecheada;
        this.molho = molho;
    }
}
