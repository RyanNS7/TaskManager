package br.com.project.TaskManager.src.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank @Email String email, String password, String name) {
}
