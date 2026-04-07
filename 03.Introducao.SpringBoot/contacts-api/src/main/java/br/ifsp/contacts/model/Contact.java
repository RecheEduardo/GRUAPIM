package br.ifsp.contacts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Classe que representa o modelo de dados para um Contato.
 *
 * @Entity indica que este objeto será mapeado para uma tabela
 * no banco de dados (em cenários de persistência com JPA).
 */
@Entity
public class Contact {

    /**
     * @Id indica que este campo é a chave primária (primary key) da entidade.
     * @GeneratedValue permite que o banco de dados (ou o provedor JPA)
     * gere automaticamente um valor único para cada novo registro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O telefone não pode estar vazio")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
    private String telefone;

    @NotBlank(message = "O email não pode estar vazio")
    @Email(message = "O email deve ter um formato válido")
    private String email;

    // Construtor vazio exigido pelo JPA
    public Contact() {}

    // Construtor para facilitar a criação de objetos
    public Contact(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}