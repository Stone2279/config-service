package de.stone.config.service.router;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MappingNotFoundException extends RuntimeException {

    public MappingNotFoundException(Long id) {
        super("No Mapping found with id: " + id);
    }

    public MappingNotFoundException(String name) {
        super("No Mappings found for document with name: " + name);
    }
}
