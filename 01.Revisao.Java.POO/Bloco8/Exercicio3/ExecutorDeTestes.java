package Bloco8.Exercicio3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecutorDeTestes {
    public static void executarTestes(Object obj) throws IllegalAccessException, InvocationTargetException{
        Class objClass = obj.getClass();    
        Method[] objMethods = objClass.getDeclaredMethods();

        for (Method method : objMethods) {
            if(method.isAnnotationPresent(Teste.class)){
                method.invoke(obj);
            }
        }
    }
}
