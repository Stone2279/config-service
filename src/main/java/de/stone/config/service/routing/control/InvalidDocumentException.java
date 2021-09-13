package de.stone.config.service.routing.control;

public class InvalidDocumentException extends Exception {

    public InvalidDocumentException() {
        super();
    }

    public InvalidDocumentException(String message) {
        super(message);
    }

    public InvalidDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDocumentException(Throwable cause) {
        super(cause);
    }
}
