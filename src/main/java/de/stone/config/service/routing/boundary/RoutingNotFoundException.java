package de.stone.config.service.routing.boundary;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoutingNotFoundException extends RuntimeException {

    public RoutingNotFoundException(Long id) {
        super("No Mapping found with id: " + id);
    }

    public RoutingNotFoundException(String name) {
        super("No Mappings found for document with name: " + name);
    }
}
