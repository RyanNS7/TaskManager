package br.com.project.TaskManager.src.adapters.in.controllers.advice;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
