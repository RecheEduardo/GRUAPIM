package Bloco4.Exercicio2;

import java.util.HashSet;

public class Exercicio2 {
    public static void main(String[] args) {
        HashSet<String> emailsStorage = new HashSet<String>();

        emailsStorage.add("emailteste1@email.com");
        emailsStorage.add("emailteste2@email.com");
        emailsStorage.add("emailteste3@email.com");
        emailsStorage.add("emailtesteDUPLICADO@email.com");
        emailsStorage.add("emailtesteDUPLICADO@email.com");

        System.out.println("Emails do HashSet:");
        System.out.println(emailsStorage);

        System.out.println("Tamanho do Set: " + emailsStorage.size());
    }
}
