package Bloco8.Exercicio1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnalisadorDeClasse {
    public static void inspecionar(Object obj){
        System.out.println("Nome completo do objeto: " + obj);

        System.out.println();

        Class<? extends Object> objClass = obj.getClass();

        System.out.println("Classe: " + objClass);
        
        System.out.println();
        
        System.out.println("Atributos:");
        Field[] objFields = objClass.getDeclaredFields();
        for (Field field : objFields) {
            System.out.println(field);
        }

        System.out.println();

        System.out.println("Métodos:");
        Method[] objMethods = objClass.getDeclaredMethods();
        for (Method method : objMethods) {
            System.out.println(method);
        }
    }
}
