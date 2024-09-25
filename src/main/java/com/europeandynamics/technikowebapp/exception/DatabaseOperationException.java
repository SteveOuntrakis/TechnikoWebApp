package com.europeandynamics.technikowebapp.exception;

public class DatabaseOperationException extends RuntimeException {

    public DatabaseOperationException(String operation, String entity) {
        super("Failed to " + operation + " " + entity);
    }

    public DatabaseOperationException(String operation, String entity, Throwable cause) {
        super("Failed to " + operation + " " + entity, cause);
    }
}
