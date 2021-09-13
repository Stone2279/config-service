package de.stone.config.service.router;

import de.stone.config.service.routing.control.DocumentRoutingRepository;
import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.entity.DocumentType;
import de.stone.config.service.routing.entity.ExpectedType;
import de.stone.config.service.routing.entity.Expression;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
class DocumentMappingRepositoryIntegrationTest {

    @Autowired
    private DocumentRoutingRepository repository;

    @BeforeEach
    public void setup() {
        createMapping();
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

        Expression exp1 = book.getExpression1();
        assertEquals("bookstore/book[@category='cooking']/title", exp1.getExpression());
        assertEquals("Everyday Italian", exp1.getExpectedValue());
        assertEquals(ExpectedType.STRING, exp1.getExpectedType());

        Expression exp2 = book.getExpression2();
        assertEquals("bookstore/book[@category='children']/title", exp2.getExpression());
        assertEquals("Harry Potter", exp2.getExpectedValue());
        assertEquals(ExpectedType.STRING, exp2.getExpectedType());

        Expression exp3 = book.getExpression3();
        assertEquals("bookstore/book[@category='children']/year", exp3.getExpression());
        assertEquals("2005", exp3.getExpectedValue());
        assertEquals(ExpectedType.NUMBER, exp3.getExpectedType());

        Expression exp4 = book.getExpression4();
        assertEquals("bookstore/book[@category='cooking']/available", exp4.getExpression());
        assertEquals("true", exp4.getExpectedValue());
        assertEquals(ExpectedType.BOOLEAN, exp4.getExpectedType());

        Expression exp5 = book.getExpression5();
        assertEquals("bookstore/book[@category='children']/price", exp5.getExpression());
        assertEquals("29.99", exp5.getExpectedValue());
        assertEquals(ExpectedType.NUMBER, exp5.getExpectedType());
    }

    @Test
    public void updateDocumentMapping() {

        List<DocumentRouting> books = repository.findByDocumentName("Books").get();
        assertEquals(1, books.size());

        DocumentRouting book = books.get(0);
        book.setDocumentName("Best Books");
        book.getExpression1().setExpectedValue("Everyday Bavarian");
        book.setExpression5(null);

        repository.saveAndFlush(book);

        books = repository.findByDocumentName("Best Books").get();
        assertEquals(1, books.size());

        book = books.get(0);
        assertEquals("Best Books", book.getDocumentName());
        assertEquals("Everyday Bavarian", book.getExpression1().getExpectedValue());
        assertNull(book.getExpression5());
    }

    @Test
    public void deleteDocumentMapping() {

        List<DocumentRouting> books = repository.findByDocumentName("Books").get();
        assertEquals(1, books.size());

        repository.delete(books.get(0));

        books = repository.findByDocumentName("Books").get();
        assertEquals(0, books.size());
    }

    private void createMapping() {

        DocumentRouting mapping1 = new DocumentRouting.Builder()
                .documentName("Books")
                .documentType(DocumentType.XML)
                .expression1(new Expression("bookstore/book[@category='cooking']/title", "Everyday Italian", ExpectedType.STRING))
                .expression2(new Expression("bookstore/book[@category='children']/title", "Harry Potter", ExpectedType.STRING))
                .expression3(new Expression("bookstore/book[@category='children']/year", "2005", ExpectedType.NUMBER))
                .expression4(new Expression("bookstore/book[@category='cooking']/available", "true", ExpectedType.BOOLEAN))
                .expression5(new Expression("bookstore/book[@category='children']/price", "29.99", ExpectedType.NUMBER))
                .build();

        repository.saveAndFlush(mapping1);
    }

    private void deleteAll() {
        repository.deleteAll();
    }
}