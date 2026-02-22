package Bloco7.Exercicio5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicio5 {
    public static void main(String[] args) {
        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        listaAlunos.add(new Aluno("Bruna", 6.1));
        listaAlunos.add(new Aluno("Carlos", 8.8));
        listaAlunos.add(new Aluno("Daniel", 7.5));
        listaAlunos.add(new Aluno("Lucas", 4.4));
        listaAlunos.add(new Aluno("João", 5.9));
        listaAlunos.add(new Aluno("Maria", 4.8));
        listaAlunos.add(new Aluno("Douglas", 8.2));
        listaAlunos.add(new Aluno("Roberta", 9.0));

        Map<String, List<Aluno>> grupoAlunosPorNota = new HashMap<String, List<Aluno>>();

        grupoAlunosPorNota.put("Aprovados", listaAlunos.stream().filter(aluno -> aluno.getNota() >= 7).toList());
        grupoAlunosPorNota.put("Recuperação", listaAlunos.stream().filter(aluno -> aluno.getNota() >= 5 && aluno.getNota() < 7).toList());
        grupoAlunosPorNota.put("Reprovados", listaAlunos.stream().filter(aluno -> aluno.getNota() < 5).toList());

        for (Map.Entry<String,List<Aluno>> grupo : grupoAlunosPorNota.entrySet()) {
            System.out.println(grupo.getKey() + ":");
            for (Aluno aluno : grupo.getValue()) {
                System.out.println(aluno.getNome() + " - Nota: " + aluno.getNota());
            }
            System.out.println();
        }
    }
}
