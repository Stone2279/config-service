package de.stone.config.service.routing.control;

import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.entity.DocumentType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class XPathEvaluatorTest {

    @Test
    public void matches() throws Exception {

        XPathEvaluator evaluator = new XPathEvaluator();
        InputStream stream = loadTestXml("src/test/resources/mapping-test.xml");
        List<DocumentRouting> matchingRoutings = getMatchingDocumentRoutings();

        Optional<String> match = evaluator.matches(stream, matchingRoutings);
        assertEquals("Bavaria", match.get());
    }

    @Test
    public void noMatch() throws Exception {
        XPathEvaluator evaluator = new XPathEvaluator();
        InputStream stream = loadTestXml("src/test/resources/mapping-test.xml");

        List<DocumentRouting> noMatchRoutings = getNoMatchDocumentRoutings();
        Optional<String> noMatch = evaluator.matches(stream, noMatchRoutings);
        assertTrue(noMatch.isEmpty());
    }

    @Test
    public void withNamespace() throws Exception {

        XPathEvaluator evaluator = new XPathEvaluator();
        InputStream stream = loadTestXml("src/test/resources/mapping-test-ns.xml");
        List<DocumentRouting> matchingRoutings = getMatchingDocumentRoutingsWithNs();

        Optional<String> match = evaluator.matches(stream, matchingRoutings);
        assertEquals("Berlin", match.get());
    }

    private InputStream loadTestXml(String path) throws IOException {

        Path filePath = Paths.get(path);
        return Files.newInputStream(filePath);
    }

    private List<DocumentRouting> getMatchingDocumentRoutings() {

        DocumentRouting routing1 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .destination("Berlin")
                .expression1("bookstore/book[@category='cooking']/title = 'Everyday Italian'")
                .expression2("bookstore/book[@category='children']/year = 2006")
                .expression3("bookstore/book[@category='children']/available = 'true'")
                .build();

        DocumentRouting routing2 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .destination("Bavaria")
                .expression1("bookstore/book[@category='cooking']/title = 'Everyday Italian'")
                .expression2("bookstore/book[@category='children']/year = 2005")
                .expression3("bookstore/book[@category='children']/available = 'true'")
                .build();

        return Arrays.asList(routing1, routing2);
    }

    private List<DocumentRouting> getNoMatchDocumentRoutings() {

        DocumentRouting routing1 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .destination("Berlin")
                .expression1("bookstore/book[@category='cooking']/title = 'Everyday Italian'")
                .expression2("bookstore/book[@category='children']/year = 2006")
                .expression3("bookstore/book[@category='children']/available = 'true'")
                .build();

        DocumentRouting routing2 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .destination("Bavaria")
                .expression1("bookstore/book[@category='cooking']/title = 'Everyday Italian'")
                .expression2("bookstore/book[@category='children']/year = 2005")
                .expression3("bookstore/book[@category='children']/available = 'false'")
                .build();

        return Arrays.asList(routing1, routing2);
    }

    private List<DocumentRouting> getMatchingDocumentRoutingsWithNs() {

        DocumentRouting routing1 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .destination("Berlin")
                .expression1("ns2:bookstore/ns2:book[@category='cooking']/ns2:title = 'Everyday Italian'")
                .expression2("ns2:bookstore/ns2:book[@category='children']/ns2:year = 2005")
                .expression3("ns2:bookstore/ns2:book[@category='children']/ns2:available = 'true'")
                .build();

        return Arrays.asList(routing1);
    }
}