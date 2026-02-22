package Bloco8.Exercicio3;

import java.lang.reflect.InvocationTargetException;

public class Exercicio3 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ClasseTeste classeTeste = new ClasseTeste();
        ExecutorDeTestes.executarTestes(classeTeste);
    }
}
