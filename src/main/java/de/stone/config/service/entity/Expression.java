package de.stone.config.service.entity;

import javax.xml.xpath.XPathConstants;
import java.util.Objects;

public class Expression {

    private Long id;

    private String expression;

    private String expectedValue;

    private XPathConstants expectedType;

    public Expression() {
    }

    public Expression(String expression, String expectedValue, XPathConstants expectedType) {
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

    public XPathConstants getExpectedType() {
        return expectedType;
    }

    public void setExpectedType(XPathConstants expectedType) {
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
