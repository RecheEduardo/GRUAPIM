package Bloco7.Exercicio5;

public class Aluno {
    private String nome;
    private Double nota;

    public String getNome() {
        return nome;
    }
    public Double getNota() {
        return nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Aluno(String nome, Double nota){
        this.nome = nome;
        this.nota = nota;
    }
}
