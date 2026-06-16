package com.gruapim.taskmaster.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruapim.taskmaster.dto.TaskRequestDTO;
import com.gruapim.taskmaster.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void limparBancoDeDados() {
        taskRepository.deleteAll();
    }

    private TaskRequestDTO criarRequestValido() {
        TaskRequestDTO dto = new TaskRequestDTO();
        dto.setTitulo("Tarefa de Teste");
        dto.setDescricao("Descrição da tarefa de teste");
        dto.setCategoria("Trabalho");
        dto.setDataLimite(LocalDate.now().plusDays(10));
        dto.setPrioridade(2);
        return dto;
    }

    private Long criarTarefaEObterIdRequest(TaskRequestDTO dto) throws Exception {
        String resposta = mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andReturn().getResponse().getContentAsString();
        return objectMapper.readTree(resposta).get("id").asLong();
    }

    // ==================== POST /tasks ====================

    @Test
    @DisplayName("POST /tasks - deve criar tarefa válida e retornar 201 com ID gerado")
    void deveCriarTarefaERetornar201() throws Exception {
        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criarRequestValido())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.titulo").value("Tarefa de Teste"))
                .andExpect(jsonPath("$.categoria").value("Trabalho"));
    }

    @Test
    @DisplayName("POST /tasks - deve retornar 400 quando título estiver ausente")
    void deveRetornar400QuandoTituloAusente() throws Exception {
        TaskRequestDTO dto = criarRequestValido();
        dto.setTitulo(null);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.mensagens", hasItem(containsString("título"))));
    }

    @Test
    @DisplayName("POST /tasks - deve retornar 400 quando prioridade for texto (tipo inválido)")
    void deveRetornar400QuandoPrioridadeForTexto() throws Exception {
        String jsonInvalido = """
                {
                    "titulo": "Minha Tarefa",
                    "prioridade": "alta"
                }
                """;

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInvalido))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensagens").isArray());
    }

    @Test
    @DisplayName("POST /tasks - deve retornar 400 quando data limite for no passado")
    void deveRetornar400QuandoDataLimiteNoPassado() throws Exception {
        TaskRequestDTO dto = criarRequestValido();
        dto.setDataLimite(LocalDate.now().minusDays(1));

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensagens[0]").value(containsString("passado")));
    }

    // ==================== PUT /tasks/{id} ====================

    @Test
    @DisplayName("PUT /tasks/{id} - deve atualizar tarefa existente e retornar 200")
    void deveAtualizarTarefaERetornar200() throws Exception {
        Long id = criarTarefaEObterIdRequest(criarRequestValido());

        TaskRequestDTO atualizar = criarRequestValido();
        atualizar.setTitulo("Tarefa Atualizada");

        mockMvc.perform(put("/tasks/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(atualizar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.titulo").value("Tarefa Atualizada"));
    }

    @Test
    @DisplayName("PUT /tasks/{id} - deve retornar 404 para ID inexistente")
    void deveRetornar404AoAtualizarTarefaInexistente() throws Exception {
        mockMvc.perform(put("/tasks/9999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criarRequestValido())))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404));
    }

    // ==================== DELETE /tasks/{id} ====================

    @Test
    @DisplayName("DELETE /tasks/{id} - deve excluir tarefa existente e retornar 204")
    void deveExcluirTarefaERetornar204() throws Exception {
        Long id = criarTarefaEObterIdRequest(criarRequestValido());

        mockMvc.perform(delete("/tasks/" + id))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /tasks/{id} - deve retornar 404 para ID inexistente")
    void deveRetornar404AoExcluirTarefaInexistente() throws Exception {
        mockMvc.perform(delete("/tasks/9999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404));
    }

    // ==================== GET /tasks ====================

    @Test
    @DisplayName("GET /tasks - deve retornar 200 com metadados de paginação")
    void deveListarTarefasComMetadadosDePaginacao() throws Exception {
        criarTarefaEObterIdRequest(criarRequestValido());

        mockMvc.perform(get("/tasks")
                        .param("page", "0")
                        .param("size", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.conteudo").isArray())
                .andExpect(jsonPath("$.numeroPagina").value(0))
                .andExpect(jsonPath("$.tamanhoPagina").value(5))
                .andExpect(jsonPath("$.totalElementos").isNumber())
                .andExpect(jsonPath("$.totalPaginas").isNumber());
    }

    @Test
    @DisplayName("GET /tasks?sort=dataLimite,asc - deve retornar tarefas ordenadas")
    void deveRetornarTarefasOrdenadasPorDataLimite() throws Exception {
        TaskRequestDTO tarefa1 = criarRequestValido();
        tarefa1.setDataLimite(LocalDate.now().plusDays(20));
        criarTarefaEObterIdRequest(tarefa1);

        TaskRequestDTO tarefa2 = criarRequestValido();
        tarefa2.setDataLimite(LocalDate.now().plusDays(5));
        criarTarefaEObterIdRequest(tarefa2);

        mockMvc.perform(get("/tasks").param("sort", "dataLimite,asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.conteudo", hasSize(2)))
                .andExpect(jsonPath("$.conteudo[0].dataLimite")
                        .value(LocalDate.now().plusDays(5).toString()));
    }

    @Test
    @DisplayName("GET /tasks?categoria=X - deve retornar apenas tarefas da categoria filtrada")
    void deveFiltrarTarefasPorCategoria() throws Exception {
        TaskRequestDTO trabalho = criarRequestValido();
        trabalho.setCategoria("Trabalho");
        criarTarefaEObterIdRequest(trabalho);

        TaskRequestDTO estudo = criarRequestValido();
        estudo.setCategoria("Estudo");
        criarTarefaEObterIdRequest(estudo);

        mockMvc.perform(get("/tasks").param("categoria", "Trabalho"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.conteudo", hasSize(1)))
                .andExpect(jsonPath("$.conteudo[0].categoria").value("Trabalho"));
    }

    @Test
    @DisplayName("GET /tasks?categoria=X - deve retornar lista vazia para categoria sem tarefas")
    void deveRetornarListaVaziaParaCategoriaInexistente() throws Exception {
        mockMvc.perform(get("/tasks").param("categoria", "CategoriaInexistente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.conteudo", hasSize(0)))
                .andExpect(jsonPath("$.totalElementos").value(0));
    }
}
