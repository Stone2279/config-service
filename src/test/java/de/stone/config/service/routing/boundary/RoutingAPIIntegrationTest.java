package de.stone.config.service.routing.boundary;

import de.stone.config.service.routing.control.DocumentRoutingRepository;
import de.stone.config.service.routing.entity.DocumentRouting;
import de.stone.config.service.routing.entity.DocumentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoutingAPIIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private DocumentRoutingRepository repository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        createRouting();
    }

    @AfterEach
    public void cleanup() {
        deleteAll();
    }

    @Test
    public void getAllDocumentRoutings() {

        ResponseEntity<List> result = this.restTemplate.getForEntity("http://localhost:" + port + "/api/routings", List.class);
        System.out.println(result);
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
