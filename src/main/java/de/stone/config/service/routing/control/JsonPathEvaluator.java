package de.stone.config.service.routing.control;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import de.stone.config.service.routing.entity.DocumentRouting;

@Component
public class JsonPathEvaluator implements Evaluator {
	
	 public Optional<String> matches(final InputStream is, List<DocumentRouting> routings) {
		 
		 Object document = parse(is);
		 
		 for (DocumentRouting routing : routings) {
			 
			 boolean matches = evaluate(document, routing.getExpression1())
                && evaluate(document, routing.getExpression2())
                && evaluate(document, routing.getExpression3())
                && evaluate(document, routing.getExpression4())
                && evaluate(document, routing.getExpression5());

            if(matches) {
                return Optional.of(routing.getDestination());
            }
        }

        return Optional.empty();
	 }
	 
	 private boolean evaluate(Object document, String exp) {

	        if(exp == null) {
	            return true;
	        }

	        try {
	        	List<Object> result = JsonPath.read(document, exp);
		        
		        if(result == null || result.size() == 0) {
		        	return false;
		        }
		        else  {
		        	return true;
		        }
	        }
	        catch(Exception e) {
	        	throw new InvalidRoutingException("Invalid mapping: " + exp, e);
	        }
	    }
	 
	 private Object parse(final InputStream is) throws InvalidDocumentException {

	        if (is == null) {
	            throw new InvalidDocumentException("No document to parse. Input is null.");
	        }

	        try {
	        	return Configuration.defaultConfiguration()
	        			.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL, Option.ALWAYS_RETURN_LIST)
	        			.jsonProvider().parse(is, "UTF-8");	        	
	        }
	        catch (InvalidJsonException e) {
	        	throw new InvalidDocumentException("Unparseable Json document", e);
	        }
	    }
}
