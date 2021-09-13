package de.stone.config.service.routing.control;

import de.stone.config.service.routing.entity.DocumentRouting;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

/**
 * TODO: XML Namespaces!!!
 */
public class XPathEvaluator {

    private XPathFactory xPathFactory = XPathFactory.newInstance();
    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    public static void validateXPath(String exp) throws XPathExpressionException {
        XPathFactory.newInstance().newXPath().compile(exp);
    }

    public Optional<String> matches(final InputStream is, List<DocumentRouting> routings) throws InvalidDocumentException, XPathExpressionException {

        Document xml = parse(is);

        for (DocumentRouting routing : routings) {

            boolean matches = evaluate(xml, routing.getExpression1());
            matches = evaluate(xml, routing.getExpression2());
            matches = evaluate(xml, routing.getExpression3());
            matches = evaluate(xml, routing.getExpression4());
            matches = evaluate(xml, routing.getExpression5());

            if(matches) {
                return Optional.of(routing.getDestination());
            }
        }

        return Optional.empty();
    }

    private boolean evaluate(Document xml, String exp) throws XPathExpressionException {

        if(exp == null) {
            return true;
        }

        XPathExpression xPathExpression = xPathFactory.newXPath().compile(exp);
        return (Boolean) xPathExpression.evaluate(xml, XPathConstants.BOOLEAN);
    }

    private Document parse(final InputStream is) throws InvalidDocumentException {

        if (is == null) {
            throw new InvalidDocumentException("No document to parse. Input is null.");
        }

        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            return builder.parse(is);
        }
        catch (final Exception e) {
            throw new InvalidDocumentException("Unparsable XML document", e);
        }
    }
}
