package de.stone.config.service.routing.boundary;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.stone.config.service.routing.control.DocumentRoutingRepository;
import de.stone.config.service.routing.control.JsonPathEvaluator;
import de.stone.config.service.routing.control.RoutingNotFoundException;
import de.stone.config.service.routing.control.XPathEvaluator;
import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.entity.DocumentType;
import de.stone.config.service.routing.entity.RoutingResult;

@RestController
@RequestMapping("api")
public class RoutingAPI {

    @Autowired
    private DocumentRoutingRepository documentRoutingRepository;
    
    @Autowired
    private JsonPathEvaluator jsonEvaluator;
    
    @Autowired
    private XPathEvaluator xpathEvaluator;

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
    
    @PostMapping(value = "routings/eval/{name}", consumes = "application/json")
    public RoutingResult evaluateJson(InputStream is, @PathVariable String name) {
    	
    	List<DocumentRouting> documentRoutings = getDocumentRoutings(name);

		Optional<String> result = jsonEvaluator.matches(is, documentRoutings);
		if(result.isEmpty()) {
			return new RoutingResult();
		}
		else {
			return new RoutingResult(result.get());
		}
    }
    
    @PostMapping(value = "routings/eval/{name}", consumes = "application/xml")
    public RoutingResult evaluateXml(InputStream is, @PathVariable String name) {
    	
    	List<DocumentRouting> documentRoutings = getDocumentRoutings(name);

		Optional<String> result = xpathEvaluator.matches(is, documentRoutings);
		if(result.isEmpty()) {
			return new RoutingResult();
		}
		else {
			return new RoutingResult(result.get());
		}
    }
    
    @PostMapping(value = "routings/eval", consumes = "application/json")
    public RoutingResult evaluateJson(InputStream is, 
    		@RequestHeader(name = "X-expression1", required = false) String expression1,
    		@RequestHeader(name = "X-expression2", required = false) String expression2,
    		@RequestHeader(name = "X-expression3", required = false) String expression3,
    		@RequestHeader(name = "X-expression4", required = false) String expression4,
    		@RequestHeader(name = "X-expression5", required = false) String expression5,
    		@RequestHeader(name = "X-destination", required = true) String destination) {
    	
    	DocumentRouting routing = new DocumentRouting.Builder()
    			.destination(destination)
    			.documentType(DocumentType.JSON)
    			.expression1(expression1)
    			.expression2(expression2)
    			.expression3(expression3)
    			.expression4(expression4)
    			.expression5(expression5).build();

		Optional<String> result = jsonEvaluator.matches(is, Arrays.asList(routing));
		if(result.isEmpty()) {
			return new RoutingResult();
		}
		else {
			return new RoutingResult(result.get());
		}

    }
    
    @PostMapping(value = "routings/eval", consumes = "application/xml")
    public RoutingResult evaluateXml(InputStream is, 
    		@RequestHeader(name = "X-expression1", required = false) String expression1,
    		@RequestHeader(name = "X-expression2", required = false) String expression2,
    		@RequestHeader(name = "X-expression3", required = false) String expression3,
    		@RequestHeader(name = "X-expression4", required = false) String expression4,
    		@RequestHeader(name = "X-expression5", required = false) String expression5,
    		@RequestHeader(name = "X-destination", required = true) String destination) {
    	
    	DocumentRouting routing = new DocumentRouting.Builder()
    			.destination(destination)
    			.documentType(DocumentType.XML)
    			.expression1(expression1)
    			.expression2(expression2)
    			.expression3(expression3)
    			.expression4(expression4)
    			.expression5(expression5).build();

		Optional<String> result = xpathEvaluator.matches(is, Arrays.asList(routing));
		if(result.isEmpty()) {
			return new RoutingResult();
		}
		else {
			return new RoutingResult(result.get());
		}
    }
}
