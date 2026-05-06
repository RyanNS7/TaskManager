package br.com.project.TaskManager.src.exceptions;

public class HandleInternalServerError extends RuntimeException {
    public HandleInternalServerError(String message) {
        super(message);
    }
}
