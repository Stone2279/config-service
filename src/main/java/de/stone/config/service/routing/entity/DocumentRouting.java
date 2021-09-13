package de.stone.config.service.routing.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="DOCUMENT_ROUTING")
public class DocumentRouting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_ROUTING_ID_SEQ")
    @SequenceGenerator(name = "DOCUMENT_ROUTING_ID_SEQ", sequenceName = "DOCUMENT_ROUTING_ID_SEQ")
    private Long id;

    @Column(name = "DOCUMENT_NAME", length = 512, nullable = false)
    private String documentName;

    @Enumerated(EnumType.STRING)
    @Column(name="DOCUMENT_TYPE", nullable = false)
    private DocumentType documentType;

    @Column(name = "DESTINATION", length = 512, nullable = false)
    private String destination;

    @Column(name="EXPRESSION_1")
    @Lob
    private String expression1;

    @Column(name="EXPRESSION_2")
    @Lob
    private String expression2;

    @Column(name="EXPRESSION_3")
    @Lob
    private String expression3;

    @Column(name="EXPRESSION_4")
    @Lob
    private String expression4;

    @Column(name="EXPRESSION_5")
    @Lob
    private String expression5;

    public DocumentRouting() {
    }

    private DocumentRouting(String documentName, DocumentType documentType, String destination, String expression1,
                            String expression2, String expression3, String expression4, String expression5) {
        this.documentName = documentName;
        this.documentType = documentType;
        this.destination = destination;
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.expression3 = expression3;
        this.expression4 = expression4;
        this.expression5 = expression5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getExpression1() {
        return expression1;
    }

    public void setExpression1(String expression1) {
        this.expression1 = expression1;
    }

    public String getExpression2() {
        return expression2;
    }

    public void setExpression2(String expression2) {
        this.expression2 = expression2;
    }

    public String getExpression3() {
        return expression3;
    }

    public void setExpression3(String expression3) {
        this.expression3 = expression3;
    }

    public String getExpression4() {
        return expression4;
    }

    public void setExpression4(String expression4) {
        this.expression4 = expression4;
    }

    public String getExpression5() {
        return expression5;
    }

    public void setExpression5(String expression5) {
        this.expression5 = expression5;
    }

    public void merge(DocumentRouting mapping) {

        if(mapping == null) {
            return;
        }

        this.documentName = mapping.getDocumentName();
        this.documentType = mapping.getDocumentType();
        this.destination = mapping.getDestination();
        this.expression1 = mapping.getExpression1();
        this.expression2 = mapping.getExpression2();
        this.expression3 = mapping.getExpression3();
        this.expression4 = mapping.getExpression4();
        this.expression5 = mapping.getExpression5();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentRouting that = (DocumentRouting) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class Builder {

        private String documentName;
        private DocumentType documentType;
        private String destination;
        private String expression1;
        private String expression2;
        private String expression3;
        private String expression4;
        private String expression5;

        public Builder documentName(String documentName) {
            this.documentName = documentName;
            return this;
        }

        public Builder documentType(DocumentType documentType) {
            this.documentType = documentType;
            return this;
        }

        public Builder destination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder expression1(String expression1) {
            this.expression1 = expression1;
            return this;
        }

        public Builder expression2(String expression2) {
            this.expression2 = expression2;
            return this;
        }

        public Builder expression3(String expression3) {
            this.expression3 = expression3;
            return this;
        }

        public Builder expression4(String expression4) {
            this.expression4 = expression4;
            return this;
        }

        public Builder expression5(String expression5) {
            this.expression5 = expression5;
            return this;
        }

        public DocumentRouting build() {
            return new DocumentRouting(this.documentName, this.documentType, this.destination,
                    this.expression1, this.expression2, this.expression3, this.expression4, this.expression5);
        }
    }
}
