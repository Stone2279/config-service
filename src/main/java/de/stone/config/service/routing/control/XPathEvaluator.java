package de.stone.config.service.routing.control;

import de.stone.config.service.routing.entity.DocumentRouting;
import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * TODO: XML Namespaces!!!
 */
public class XPathEvaluator {

    private XPathFactory xPathFactory = XPathFactory.newInstance();
    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    public XPathEvaluator() {
        builderFactory.setNamespaceAware(true);
    }

    public static void validateXPath(String exp) throws XPathExpressionException {
        XPathFactory.newInstance().newXPath().compile(exp);
    }

    public Optional<String> matches(final InputStream is, List<DocumentRouting> routings) throws InvalidDocumentException, XPathExpressionException {

        Document xml = parse(is);

        for (DocumentRouting routing : routings) {

            boolean matches = evaluate(xml, routing.getExpression1())
                && evaluate(xml, routing.getExpression2())
                && evaluate(xml, routing.getExpression3())
                && evaluate(xml, routing.getExpression4())
                && evaluate(xml, routing.getExpression5());

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

        XPath xpath = xPathFactory.newXPath();
        xpath.setNamespaceContext(new NamespaceResolver(xml));
        XPathExpression xPathExpression = xpath.compile(exp);
        boolean result = (Boolean) xPathExpression.evaluate(xml, XPathConstants.BOOLEAN);

        return result;
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
            throw new InvalidDocumentException("Unparseable XML document", e);
        }
    }

    class NamespaceResolver implements NamespaceContext
    {
        private Document sourceDocument;

        public NamespaceResolver(Document document) {
            sourceDocument = document;
        }

        public String getNamespaceURI(String prefix) {

            if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
                return sourceDocument.lookupNamespaceURI(null);
            } else {
                return sourceDocument.lookupNamespaceURI(prefix);
            }
        }

        public String getPrefix(String namespaceURI) {
            return sourceDocument.lookupPrefix(namespaceURI);
        }

        @SuppressWarnings("rawtypes")
        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }
    }
}
