package de.stone.config.service.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="DOCUMENT_MAPPING")
public class DocumentMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documentmapping_id_seq")
    @SequenceGenerator(name = "documentmapping_id_seq", sequenceName = "documentmapping_id_seq")
    private Long id;

    @Column(name = "DOCUMENT_NAME", length = 512, nullable = false)
    private String documentName;

    @Enumerated(EnumType.STRING)
    @Column(name="DOCUMENT_TYPE")
    private DocumentType documentType;

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

    public DocumentMapping() {
    }

    private DocumentMapping(String documentName, DocumentType documentType, Expression expression1,
                           Expression expression2, Expression expression3, Expression expression4,
                           Expression expression5) {
        this.documentName = documentName;
        this.documentType = documentType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentMapping that = (DocumentMapping) o;
        return Objects.equals(id, that.id) && Objects.equals(documentName, that.documentName) && documentType == that.documentType && Objects.equals(expression1, that.expression1) && Objects.equals(expression2, that.expression2) && Objects.equals(expression3, that.expression3) && Objects.equals(expression4, that.expression4) && Objects.equals(expression5, that.expression5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentName, documentType, expression1, expression2, expression3, expression4, expression5);
    }

    @Override
    public String toString() {
        return "DocumentMapping{" +
                "id=" + id +
                ", documentName='" + documentName + '\'' +
                ", documentType=" + documentType +
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

        public DocumentMapping build() {
            return new DocumentMapping(this.documentName, this.documentType,
                    this.expression1, this.expression2, this.expression3, this.expression4, this.expression5);
        }
    }
}
