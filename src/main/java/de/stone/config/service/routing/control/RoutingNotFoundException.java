package de.stone.config.service.routing.control;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoutingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1947341882155166784L;

	public RoutingNotFoundException(Long id) {
        super("No Mapping or Routing found with id: " + id);
    }

    public RoutingNotFoundException(String name) {
        super("No Mappings or Routings found for document with name: " + name);
    }
}
