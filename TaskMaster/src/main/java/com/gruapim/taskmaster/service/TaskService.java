package com.gruapim.taskmaster.service;

import com.gruapim.taskmaster.dto.PagedResponseDTO;
import com.gruapim.taskmaster.dto.TaskRequestDTO;
import com.gruapim.taskmaster.dto.TaskResponseDTO;
import com.gruapim.taskmaster.exception.BusinessRuleException;
import com.gruapim.taskmaster.exception.TaskNotFoundException;
import com.gruapim.taskmaster.model.Task;
import com.gruapim.taskmaster.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskResponseDTO criar(TaskRequestDTO dto) {
        validarDataLimite(dto.getDataLimite());
        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setCategoria(dto.getCategoria());
        task.setDataLimite(dto.getDataLimite());
        task.setPrioridade(dto.getPrioridade());
        return new TaskResponseDTO(taskRepository.save(task));
    }

    @Transactional
    public TaskResponseDTO atualizar(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        validarDataLimite(dto.getDataLimite());
        task.setTitulo(dto.getTitulo());
        task.setDescricao(dto.getDescricao());
        task.setCategoria(dto.getCategoria());
        task.setDataLimite(dto.getDataLimite());
        task.setPrioridade(dto.getPrioridade());
        return new TaskResponseDTO(taskRepository.save(task));
    }

    @Transactional
    public void excluir(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public PagedResponseDTO<TaskResponseDTO> listar(String categoria, Pageable pageable) {
        Page<Task> page = (categoria != null && !categoria.isBlank())
                ? taskRepository.findByCategoria(categoria, pageable)
                : taskRepository.findAll(pageable);
        return new PagedResponseDTO<>(page.map(TaskResponseDTO::new));
    }

    private void validarDataLimite(LocalDate dataLimite) {
        if (dataLimite != null && dataLimite.isBefore(LocalDate.now())) {
            throw new BusinessRuleException("A data limite não pode ser uma data no passado");
        }
    }
}
