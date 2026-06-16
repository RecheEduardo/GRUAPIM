package com.gruapim.taskmaster.service;

import com.gruapim.taskmaster.dto.PagedResponseDTO;
import com.gruapim.taskmaster.dto.TaskRequestDTO;
import com.gruapim.taskmaster.dto.TaskResponseDTO;
import com.gruapim.taskmaster.exception.BusinessRuleException;
import com.gruapim.taskmaster.exception.TaskNotFoundException;
import com.gruapim.taskmaster.model.Task;
import com.gruapim.taskmaster.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private TaskRequestDTO requestDTO;
    private Task taskSalva;

    @BeforeEach
    void setUp() {
        requestDTO = new TaskRequestDTO();
        requestDTO.setTitulo("Estudar Spring Boot");
        requestDTO.setDescricao("Capítulos 3 e 4");
        requestDTO.setCategoria("Estudo");
        requestDTO.setDataLimite(LocalDate.now().plusDays(7));
        requestDTO.setPrioridade(3);

        taskSalva = new Task();
        taskSalva.setId(1L);
        taskSalva.setTitulo("Estudar Spring Boot");
        taskSalva.setDescricao("Capítulos 3 e 4");
        taskSalva.setCategoria("Estudo");
        taskSalva.setDataLimite(LocalDate.now().plusDays(7));
        taskSalva.setPrioridade(3);
    }

    @Test
    @DisplayName("Deve criar tarefa com dados válidos e retornar DTO com ID")
    void deveCriarTarefaComDadosValidos() {
        when(taskRepository.save(any(Task.class))).thenReturn(taskSalva);

        TaskResponseDTO resultado = taskService.criar(requestDTO);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getTitulo()).isEqualTo("Estudar Spring Boot");
        assertThat(resultado.getCategoria()).isEqualTo("Estudo");
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    @DisplayName("Deve lançar BusinessRuleException ao criar tarefa com data no passado")
    void deveLancarExcecaoAoCriarTarefaComDataNoPassado() {
        requestDTO.setDataLimite(LocalDate.now().minusDays(1));

        assertThatThrownBy(() -> taskService.criar(requestDTO))
                .isInstanceOf(BusinessRuleException.class)
                .hasMessageContaining("data limite não pode ser uma data no passado");

        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    @DisplayName("Deve atualizar tarefa existente com sucesso")
    void deveAtualizarTarefaExistente() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskSalva));
        when(taskRepository.save(any(Task.class))).thenReturn(taskSalva);

        TaskResponseDTO resultado = taskService.atualizar(1L, requestDTO);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getTitulo()).isEqualTo("Estudar Spring Boot");
        verify(taskRepository).findById(1L);
        verify(taskRepository).save(any(Task.class));
    }

    @Test
    @DisplayName("Deve lançar TaskNotFoundException ao atualizar tarefa com ID inexistente")
    void deveLancarExcecaoAoAtualizarTarefaInexistente() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> taskService.atualizar(99L, requestDTO))
                .isInstanceOf(TaskNotFoundException.class)
                .hasMessageContaining("99");

        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    @DisplayName("Deve excluir tarefa existente sem lançar exceção")
    void deveExcluirTarefaExistente() {
        when(taskRepository.existsById(1L)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(1L);

        assertThatCode(() -> taskService.excluir(1L)).doesNotThrowAnyException();

        verify(taskRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Deve lançar TaskNotFoundException ao excluir tarefa com ID inexistente")
    void deveLancarExcecaoAoExcluirTarefaInexistente() {
        when(taskRepository.existsById(99L)).thenReturn(false);

        assertThatThrownBy(() -> taskService.excluir(99L))
                .isInstanceOf(TaskNotFoundException.class)
                .hasMessageContaining("99");

        verify(taskRepository, never()).deleteById(any());
    }

    @Test
    @DisplayName("Deve listar todas as tarefas paginadas quando categoria não for informada")
    void deveListarTodasAsTarefasSemFiltro() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
        Page<Task> page = new PageImpl<>(List.of(taskSalva), pageable, 1);
        when(taskRepository.findAll(pageable)).thenReturn(page);

        PagedResponseDTO<TaskResponseDTO> resultado = taskService.listar(null, pageable);

        assertThat(resultado.getConteudo()).hasSize(1);
        assertThat(resultado.getTotalElementos()).isEqualTo(1);
        assertThat(resultado.getNumeroPagina()).isEqualTo(0);
        verify(taskRepository).findAll(pageable);
        verify(taskRepository, never()).findByCategoria(any(), any());
    }

    @Test
    @DisplayName("Deve filtrar tarefas por categoria ao receber parâmetro")
    void deveFiltrarTarefasPorCategoria() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
        Page<Task> page = new PageImpl<>(List.of(taskSalva), pageable, 1);
        when(taskRepository.findByCategoria("Estudo", pageable)).thenReturn(page);

        PagedResponseDTO<TaskResponseDTO> resultado = taskService.listar("Estudo", pageable);

        assertThat(resultado.getConteudo()).hasSize(1);
        assertThat(resultado.getConteudo().get(0).getCategoria()).isEqualTo("Estudo");
        verify(taskRepository).findByCategoria("Estudo", pageable);
        verify(taskRepository, never()).findAll(any(Pageable.class));
    }
}
