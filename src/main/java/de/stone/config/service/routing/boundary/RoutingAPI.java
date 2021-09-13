package de.stone.config.service.routing.boundary;

import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.control.DocumentRoutingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RoutingAPI {

    @Autowired
    private DocumentRoutingRepository documentRoutingRepository;

    @GetMapping(value = "routings")
    public List<DocumentRouting> getAllDocumentRoutings() {

        return documentRoutingRepository.findAll();
    }

    @GetMapping(value = "routings/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<DocumentRouting> getDocumentRoutings(@PathVariable String name) {

        List<DocumentRouting> result = documentRoutingRepository.findByDocumentName(name).get();
        if (result.size() == 0) {
            throw new RoutingNotFoundException(name);
        }

        return result;
    }

    @GetMapping(value = "routing/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DocumentRouting getDocumentRouting(@PathVariable Long id) {

        return documentRoutingRepository.findById(id).orElseThrow(() -> new RoutingNotFoundException(id));
    }

    @PutMapping(value = "routing/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DocumentRouting updateDocumentRouting(@RequestBody DocumentRouting documentRouting, @PathVariable Long id) {

        return documentRoutingRepository.findById(id)
                .map(result -> {
                    result.merge(documentRouting);
                    return documentRoutingRepository.save(result);
                })
                .orElseThrow(() -> new RoutingNotFoundException(id));
    }

    @PostMapping(value = "routing", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DocumentRouting createDocumentRouting(@RequestBody DocumentRouting documentRouting) {

        return documentRoutingRepository.save(documentRouting);
    }

    @DeleteMapping("routing/{id}")
    public void deleteMapping(@PathVariable Long id) {

        documentRoutingRepository.deleteById(id);
    }
}
