package br.com.project.TaskManager.src.DTO;

import br.com.project.TaskManager.src.Status;

import java.util.UUID;

public record UpdateTaskDTO(UUID idTask, String title, String description, Status status) {
}
