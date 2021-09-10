package de.stone.config.service.router;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.util.List;

public class XPathEvaluator {

    XPath xPath = XPathFactory.newInstance().newXPath();

    public boolean matches(final InputStream is, List<String> expressions) throws InvalidDocumentException, XPathExpressionException {

        Document doc = parse(is);


        for (String expression : expressions) {

        }

        return false;
    }

    private XPathExpression compileXpathExpression(final String exp) throws XPathExpressionException {
        return xPath.compile(exp);
    }

    private Document parse(final InputStream is) throws InvalidDocumentException {

        if (is == null) {
            throw new InvalidDocumentException("No document to parse. Input is null.");
        }

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            return builder.parse(is);
        }
        catch (final Exception e) {
            throw new InvalidDocumentException("Invalid XML document", e);
        }
    }
}
