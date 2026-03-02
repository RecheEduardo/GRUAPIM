package Lanchonete.Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lanche extends Prato {
    private String tipoDePao;
    private String recheio;
    private ArrayList<String> molhos;

    public String getTipoDePao() {
        return tipoDePao;
    }
    public String getRecheio() {
        return recheio;
    }
    public ArrayList<String> getMolhos() {
        return molhos;
    }

    public void setTipoDePao(String tipoDePao) {
        this.tipoDePao = tipoDePao;
    }
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    public void setMolhos(ArrayList<String> molhos) {
        this.molhos = molhos;
    }


    public Lanche(Double precoDeVenda, LocalDate dataValidade,
        Double peso, ArrayList<String> molhos, String recheio, String tipoDePao) {
        super(precoDeVenda, dataValidade, peso);
        this.molhos = molhos;
        this.tipoDePao = tipoDePao;
        this.recheio = recheio;
    }
}
