package br.com.project.TaskManager.src.exceptions;

public class InsufficientCharactersException extends RuntimeException {
    public InsufficientCharactersException(String message) {
        super(message);
    }
}
