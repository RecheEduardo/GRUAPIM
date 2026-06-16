package com.gruapim.taskmaster.dto;

import com.gruapim.taskmaster.model.Task;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Dados de resposta de uma tarefa")
public class TaskResponseDTO {

    @Schema(description = "ID único da tarefa")
    private Long id;

    @Schema(description = "Título da tarefa")
    private String titulo;

    @Schema(description = "Descrição da tarefa")
    private String descricao;

    @Schema(description = "Categoria da tarefa")
    private String categoria;

    @Schema(description = "Data limite da tarefa")
    private LocalDate dataLimite;

    @Schema(description = "Prioridade da tarefa (1-5)")
    private Integer prioridade;

    public TaskResponseDTO() {}

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.titulo = task.getTitulo();
        this.descricao = task.getDescricao();
        this.categoria = task.getCategoria();
        this.dataLimite = task.getDataLimite();
        this.prioridade = task.getPrioridade();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public LocalDate getDataLimite() { return dataLimite; }
    public void setDataLimite(LocalDate dataLimite) { this.dataLimite = dataLimite; }

    public Integer getPrioridade() { return prioridade; }
    public void setPrioridade(Integer prioridade) { this.prioridade = prioridade; }
}
