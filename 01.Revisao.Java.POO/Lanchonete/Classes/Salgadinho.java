package Lanchonete.Classes;

import java.time.LocalDate;

public class Salgadinho extends Prato {

    private String tipo;
    private String massa;
    private String recheio;

    public String getTipo() {
        return tipo;
    }
    public String getMassa() {
        return massa;
    }
    public String getRecheio() {
        return recheio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setMassa(String massa) {
        this.massa = massa;
    }
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public Salgadinho(Double precoDeVenda, LocalDate dataValidade, Double peso) {
        super(precoDeVenda, dataValidade, peso);
    }
}
