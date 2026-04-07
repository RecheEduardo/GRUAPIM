package AcademiaDev;

public class Main {

    public static void main(String[] args) {
        Course curso = new Course("Java Básico", "Introdução à linguagem", "Prof. Silva",
                40, DifficultyLevel.BEGINNER, CourseStatus.ACTIVE);
        Student aluno = new Student("João", "joao@email.com", new BasicPlan());

        System.out.println("AcademiaDev - Protótipo base");
        System.out.println("Curso: " + curso.getTitle() + " | Aluno: " + aluno.getName());
    }
}
