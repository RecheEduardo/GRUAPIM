package com.gruapim.taskmaster.controller;

import com.gruapim.taskmaster.dto.PagedResponseDTO;
import com.gruapim.taskmaster.dto.TaskRequestDTO;
import com.gruapim.taskmaster.dto.TaskResponseDTO;
import com.gruapim.taskmaster.exception.ErrorResponse;
import com.gruapim.taskmaster.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tarefas", description = "Endpoints para gerenciamento de tarefas")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Criar nova tarefa", description = "Cria uma nova tarefa com os dados fornecidos")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso",
                content = @Content(schema = @Schema(implementation = TaskResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos ou ausentes",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<TaskResponseDTO> criar(@Valid @RequestBody TaskRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar tarefa", description = "Atualiza todos os dados de uma tarefa existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso",
                content = @Content(schema = @Schema(implementation = TaskResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Tarefa não encontrada",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<TaskResponseDTO> atualizar(
            @Parameter(description = "ID da tarefa") @PathVariable Long id,
            @Valid @RequestBody TaskRequestDTO dto) {
        return ResponseEntity.ok(taskService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir tarefa", description = "Remove permanentemente uma tarefa")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Tarefa excluída com sucesso"),
        @ApiResponse(responseCode = "404", description = "Tarefa não encontrada",
                content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID da tarefa") @PathVariable Long id) {
        taskService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Listar tarefas",
            description = "Lista tarefas com paginação, ordenação e filtro opcional por categoria")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<PagedResponseDTO<TaskResponseDTO>> listar(
            @Parameter(description = "Filtrar por categoria") @RequestParam(required = false) String categoria,
            @Parameter(description = "Número da página (0-indexed)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Itens por página") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Ordenação: campo,direção (ex: dataLimite,asc)")
                @RequestParam(defaultValue = "id,asc") String sort) {

        String[] partes = sort.split(",");
        String campo = partes[0].trim();
        Sort.Direction direcao = partes.length > 1 && partes[1].trim().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direcao, campo));
        return ResponseEntity.ok(taskService.listar(categoria, pageable));
    }
}
