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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPRESSION_1", referencedColumnName = "id")
    private Expression expression1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPRESSION_2", referencedColumnName = "id")
    private Expression expression2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPRESSION_3", referencedColumnName = "id")
    private Expression expression3;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPRESSION_4", referencedColumnName = "id")
    private Expression expression4;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPRESSION_5", referencedColumnName = "id")
    private Expression expression5;

    public DocumentRouting() {
    }

    private DocumentRouting(String documentName, DocumentType documentType, String destination, Expression expression1,
                            Expression expression2, Expression expression3, Expression expression4,
                            Expression expression5) {
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

    public Expression getExpression1() {
        return expression1;
    }

    public void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    public void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }

    public Expression getExpression3() {
        return expression3;
    }

    public void setExpression3(Expression expression3) {
        this.expression3 = expression3;
    }

    public Expression getExpression4() {
        return expression4;
    }

    public void setExpression4(Expression expression4) {
        this.expression4 = expression4;
    }

    public Expression getExpression5() {
        return expression5;
    }

    public void setExpression5(Expression expression5) {
        this.expression5 = expression5;
    }

    public void merge(DocumentRouting mapping) {

        if(mapping == null) {
            return;
        }

        this.documentName = mapping.getDocumentName();
        this.documentType = mapping.getDocumentType();
        this.destination = mapping.getDestination();

        if(this.expression1 != null) {
            this.expression1.merge(mapping.getExpression1());
        }
        else {
            this.expression1 = mapping.getExpression1();
        }

        if(this.expression2 != null) {
            this.expression2.merge(mapping.getExpression2());
        }
        else {
            this.expression2 = mapping.getExpression2();
        }

        if(this.expression3 != null) {
            this.expression3.merge(mapping.getExpression3());
        }
        else {
            this.expression3 = mapping.getExpression3();
        }

        if(this.expression4 != null) {
            this.expression4.merge(mapping.getExpression4());
        }
        else {
            this.expression4 = mapping.getExpression4();
        }

        if(this.expression5 != null) {
            this.expression5.merge(mapping.getExpression5());
        }
        else {
            this.expression5 = mapping.getExpression5();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentRouting that = (DocumentRouting) o;
        return Objects.equals(id, that.id) && Objects.equals(documentName, that.documentName)
                && documentType == that.documentType && Objects.equals(expression1, that.expression1)
                && Objects.equals(expression2, that.expression2) && Objects.equals(expression3, that.expression3)
                && Objects.equals(expression4, that.expression4) && Objects.equals(expression5, that.expression5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentName, documentType, expression1, expression2,
                expression3, expression4, expression5);
    }

    @Override
    public String toString() {
        return "DocumentRouting{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", documentType=" + documentType +
                ", destination='" + destination + '\'' +
                ", expression1=" + expression1 +
                ", expression2=" + expression2 +
                ", expression3=" + expression3 +
                ", expression4=" + expression4 +
                ", expression5=" + expression5 +
                '}';
    }

    public static class Builder {

        private String documentName;
        private DocumentType documentType;
        private String destination;
        private Expression expression1;
        private Expression expression2;
        private Expression expression3;
        private Expression expression4;
        private Expression expression5;

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

        public Builder expression1(Expression expression1) {
            this.expression1 = expression1;
            return this;
        }

        public Builder expression2(Expression expression2) {
            this.expression2 = expression2;
            return this;
        }

        public Builder expression3(Expression expression3) {
            this.expression3 = expression3;
            return this;
        }

        public Builder expression4(Expression expression4) {
            this.expression4 = expression4;
            return this;
        }

        public Builder expression5(Expression expression5) {
            this.expression5 = expression5;
            return this;
        }

        public DocumentRouting build() {
            return new DocumentRouting(this.documentName, this.documentType, this.destination,
                    this.expression1, this.expression2, this.expression3, this.expression4, this.expression5);
        }
    }
}
