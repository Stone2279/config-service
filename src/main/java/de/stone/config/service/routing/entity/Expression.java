package de.stone.config.service.routing.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="EXPRESSION")
public class Expression {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPRESSION_ID_SEQ")
    @SequenceGenerator(name = "EXPRESSION_ID_SEQ", sequenceName = "EXPRESSION_ID_SEQ")
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

    public void merge(Expression exp) {

        if(exp == null) {
            return;
        }

        this.expression = exp.getExpression();
        this.expectedValue = exp.getExpectedValue();
        this.expectedType = exp.getExpectedType();

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
