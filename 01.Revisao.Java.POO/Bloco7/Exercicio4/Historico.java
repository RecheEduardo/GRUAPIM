package Bloco7.Exercicio4;

import java.util.LinkedList;

public class Historico {
    public LinkedList<String> listaHistorico;

    public void visitar(String url){
        listaHistorico.add(url);
    };

    public void voltar(){
    };

    public void avancar(){

    };

    public void exibirHistorico(){
        for (String registro : listaHistorico) {
            System.out.println(listaHistorico.indexOf(registro) + " - Acessou " + registro);
        }
    }


}
