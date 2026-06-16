package com.gruapim.taskmaster.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Dados para criação ou atualização de uma tarefa")
public class TaskRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 255, message = "O título deve ter no máximo 255 caracteres")
    @Schema(description = "Título da tarefa", example = "Estudar Spring Boot", requiredMode = Schema.RequiredMode.REQUIRED)
    private String titulo;

    @Schema(description = "Descrição detalhada da tarefa", example = "Revisar capítulos 3 e 4")
    private String descricao;

    @Schema(description = "Categoria da tarefa", example = "Trabalho")
    private String categoria;

    @Schema(description = "Data limite (formato: YYYY-MM-DD)", example = "2025-12-31")
    private LocalDate dataLimite;

    @Min(value = 1, message = "A prioridade deve ser entre 1 e 5")
    @Max(value = 5, message = "A prioridade deve ser entre 1 e 5")
    @Schema(description = "Prioridade da tarefa (1 = baixa, 5 = alta)", example = "3")
    private Integer prioridade;

    public TaskRequestDTO() {}

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
