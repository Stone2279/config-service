package de.stone.config.service.api;

import de.stone.config.service.entity.DocumentMapping;
import de.stone.config.service.router.DocumentMappingRepository;
import de.stone.config.service.router.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ConfigServiceController {

    @Autowired
    private DocumentMappingRepository documentMappingRepository;

    @GetMapping(value = "mappings")
    public List<DocumentMapping> getAllDocumentMappings() {

        return documentMappingRepository.findAll();
    }

    @GetMapping(value = "mappings/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<DocumentMapping> getDocumentMappings(@PathVariable String name) {

        List<DocumentMapping> result = documentMappingRepository.findByDocumentName(name).get();
        if (result.size() == 0) {
            throw new MappingNotFoundException(name);
        }

        return result;
    }

    @GetMapping(value = "mapping/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DocumentMapping getDocumentMapping(@PathVariable Long id) {

        return documentMappingRepository.findById(id).orElseThrow(() -> new MappingNotFoundException(id));
    }

    @PutMapping(value = "mapping/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DocumentMapping updateDocumentMapping(@RequestBody DocumentMapping documentMapping, @PathVariable Long id) {

        return documentMappingRepository.findById(id)
                .map(result -> {
                    result.setDocumentName(documentMapping.getDocumentName());
                    result.setDocumentType(documentMapping.getDocumentType());
                    result.setExpression1(documentMapping.getExpression1());
                    result.setExpression2(documentMapping.getExpression2());
                    result.setExpression3(documentMapping.getExpression3());
                    result.setExpression4(documentMapping.getExpression4());
                    result.setExpression5(documentMapping.getExpression5());

                    return documentMappingRepository.save(result);
                })
                .orElseThrow(() -> new MappingNotFoundException(id));
    }

    @PostMapping(value = "mapping", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DocumentMapping createDocumentMapping(@RequestBody DocumentMapping documentMapping) {

        return documentMappingRepository.save(documentMapping);
    }

    @DeleteMapping("mapping/{id}")
    public void deleteMapping(@PathVariable Long id) {

        documentMappingRepository.deleteById(id);
    }
}
