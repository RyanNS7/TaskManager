package br.com.project.TaskManager.src.DTO;

import java.util.UUID;

public record TaskDTO(String title, String description, UUID projectID) {
}
