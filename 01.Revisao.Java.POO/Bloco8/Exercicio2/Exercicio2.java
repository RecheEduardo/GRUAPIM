package Bloco8.Exercicio2;

import java.lang.reflect.Field;

public class Exercicio2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Configuracao configuracao = new Configuracao();
        Class<? extends Configuracao> classeConexao = configuracao.getClass();
        Field fieldConexao = classeConexao.getDeclaredField("urlConexao");
        
        fieldConexao.setAccessible(true);

        System.out.println("URL de conexão ANTES do override: " + fieldConexao.get(configuracao));

        fieldConexao.set(configuracao, "localhost:3000");
        System.out.println("URL de conexão DEPOIS do override: " + fieldConexao.get(configuracao));
    }
}
