package Bloco8.Exercicio3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME) // Essencial para que a anotação esteja disponível via reflection
@Target(ElementType.METHOD) // A anotação só pode ser aplicada a métodos
public @interface Teste {
}
