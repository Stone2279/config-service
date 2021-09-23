package de.stone.config.service.routing.control;

import de.stone.config.service.routing.control.DocumentRoutingRepository;
import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.entity.DocumentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
class DocumentRoutingRepositoryIntegrationTest {

    @Autowired
    private DocumentRoutingRepository repository;

    @BeforeEach
    public void setup() {
        createRouting();
    }

    @AfterEach
    public void cleanup() {
        deleteAll();
    }

    @Test
    public void findByDocumentName() {

        List<DocumentRouting> books = repository.findByDocumentName("Books").get();
        assertEquals(1, books.size());

        DocumentRouting book = books.get(0);

        assertEquals("Books", book.getDocumentName());
        assertEquals(DocumentType.XML, book.getDocumentType());
        assertEquals("bookstore/book[@category='cooking']/title", book.getExpression1());
        assertEquals("bookstore/book[@category='children']/title", book.getExpression2());
        assertEquals("bookstore/book[@category='children']/year", book.getExpression3());
        assertEquals("bookstore/book[@category='cooking']/available", book.getExpression4());
        assertEquals("bookstore/book[@category='children']/price", book.getExpression5());
    }

    @Test
    public void updateDocumentRouting() {

        List<DocumentRouting> books = repository.findByDocumentName("Books").get();
        assertEquals(1, books.size());

        DocumentRouting book = books.get(0);
        book.setDocumentName("Best Books");
        book.setExpression1("bookstore/book[@category='baking']/title");
        book.setExpression5(null);

        repository.saveAndFlush(book);

        books = repository.findByDocumentName("Best Books").get();
        assertEquals(1, books.size());

        book = books.get(0);
        assertEquals("Best Books", book.getDocumentName());
        assertEquals("bookstore/book[@category='baking']/title", book.getExpression1());
        assertNull(book.getExpression5());
    }

    @Test
    public void deleteDocumentRouting() {

        List<DocumentRouting> books = repository.findByDocumentName("Books").get();
        assertEquals(1, books.size());

        repository.delete(books.get(0));

        books = repository.findByDocumentName("Books").get();
        assertEquals(0, books.size());
    }

    private void createRouting() {

        DocumentRouting routing = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .destination("Bavaria")
                .expression1("bookstore/book[@category='cooking']/title")
                .expression2("bookstore/book[@category='children']/title")
                .expression3("bookstore/book[@category='children']/year")
                .expression4("bookstore/book[@category='cooking']/available")
                .expression5("bookstore/book[@category='children']/price")
                .build();

        repository.saveAndFlush(routing);
    }

    private void deleteAll() {
        repository.deleteAll();
    }
}