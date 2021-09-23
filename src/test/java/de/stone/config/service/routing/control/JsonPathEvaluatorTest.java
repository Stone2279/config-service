package de.stone.config.service.routing.control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.entity.DocumentType;

public class JsonPathEvaluatorTest {

	
	 @Test
    public void matches() throws Exception {

		JsonPathEvaluator evaluator = new JsonPathEvaluator();
		InputStream stream = loadTestJson("src/test/resources/mapping-test.json");
        List<DocumentRouting> matchingRoutings = getMatchingDocumentRoutings();

        Optional<String> match = evaluator.matches(stream, matchingRoutings);
        assertEquals("Bavaria", match.get());
    }

    @Test
    public void noMatch() throws Exception {
    	
    	JsonPathEvaluator evaluator = new JsonPathEvaluator();
    	InputStream stream = loadTestJson("src/test/resources/mapping-test.json");
        List<DocumentRouting> noMatchRoutings = getNoMatchDocumentRoutings();
        
        Optional<String> noMatch = evaluator.matches(stream, noMatchRoutings);
        assertTrue(noMatch.isEmpty());
    }
	
	private InputStream loadTestJson(String path) throws IOException {

        Path filePath = Paths.get(path);
        return Files.newInputStream(filePath);
    }
	
	private List<DocumentRouting> getMatchingDocumentRoutings() {

        DocumentRouting routing1 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.JSON)
                .destination("Berlin")
                .expression1("$.store.book[?(@.category == 'reference')]")
                .expression2("$.store.book[?(@.author == 'Evelyn Waugh')]")
                .expression3("$.store.book[?(@.isbn == 'bla')]")
                .build();

        DocumentRouting routing2 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.JSON)
                .destination("Bavaria")
                .expression1("$.store.book[?(@.category == 'fiction')]")
                .expression2("$.store.book[?(@.author == 'Evelyn Waugh')]")
                .expression3("$.store.book[?(@.isbn != '')]")
                .build();

        return Arrays.asList(routing1, routing2);
    }

    private List<DocumentRouting> getNoMatchDocumentRoutings() {

        DocumentRouting routing1 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.JSON)
                .destination("Berlin")
                .expression1("$.store.book[?(@.category == 'fiction')]")
                .expression2("$.store.book[?(@.author == 'Rosane Waugh')]")
                .expression3("$.store.book[?(@.isbn != '')]")
                .build();

        DocumentRouting routing2 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.JSON)
                .destination("Bavaria")
                .expression1("$.store.book[?(@.category == 'nature')]")
                .expression2("$.store.book[?(@.author == 'Evelyn Wuff')]")
                .expression3("$.store.book[?(@.isbn < 1)]")
                .build();

        return Arrays.asList(routing1, routing2);
    }
}
