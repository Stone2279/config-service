package de.stone.config.service.routing.control;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRoutingException extends RuntimeException {

	private static final long serialVersionUID = 3989222837932660933L;

	public InvalidRoutingException() {
        super();
    }

    public InvalidRoutingException(String message) {
        super(message);
    }

    public InvalidRoutingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRoutingException(Throwable cause) {
        super(cause);
    }
}
