package de.stone.config.service.entity;

import javax.persistence.*;
import javax.xml.xpath.XPathConstants;
import java.util.Objects;

@Entity
@Table(name="EXPRESSION")
public class Expression {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expression_id_seq")
    @SequenceGenerator(name = "expression_id_seq", sequenceName = "expression_id_seq")
    private Long id;

    @Column(name="EXP")
    @Lob
    private String expression;

    @Column(name="EXPECTED_VALUE")
    private String expectedValue;

    @Enumerated(EnumType.STRING)
    @Column(name="EXPECTED_TYPE")
    private ExpectedType expectedType;

    public Expression() {
    }

    public Expression(String expression, String expectedValue, ExpectedType expectedType) {
        this.expression = expression;
        this.expectedValue = expectedValue;
        this.expectedType = expectedType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public ExpectedType getExpectedType() {
        return expectedType;
    }

    public void setExpectedType(ExpectedType expectedType) {
        this.expectedType = expectedType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(id, that.id) && Objects.equals(expression, that.expression) && Objects.equals(expectedValue, that.expectedValue) && Objects.equals(expectedType, that.expectedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expression, expectedValue, expectedType);
    }

    @Override
    public String toString() {
        return "Expression{" +
                "id=" + id +
                ", expression='" + expression + '\'' +
                ", expectedValue='" + expectedValue + '\'' +
                ", expectedType=" + expectedType +
                '}';
    }
}
