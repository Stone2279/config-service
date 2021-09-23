INSERT INTO DOCUMENT_ROUTING (ID, DOCUMENT_NAME, DOCUMENT_TYPE, DESTINATION, EXPRESSION_1, EXPRESSION_2, EXPRESSION_3, EXPRESSION_4, EXPRESSION_5) VALUES
(1, 'Books', 'XML', 'Party', 'bookstore/book[@category=''cooking'']/title = ''Everyday Italian''',
'bookstore/book[@category=''children'']/title = ''Harry Potter''',
'bookstore/book[@category=''children'']/year = 2005',
'bookstore/book[@category=''cooking'']/available = ''true''',
'bookstore/book[@category=''children'']/price = ''29.99''');

INSERT INTO LOCATION_MAPPING (ALIAS, STAGE, DESTINATION) VALUES ('VIB', 'PROD', 'http://vib-eai.internal.draexlmaier.com');
INSERT INTO LOCATION_MAPPING (ALIAS, STAGE, DESTINATION) VALUES ('VIB', 'QUAL', 'http://vib-qual-eai.internal.draexlmaier.com');
INSERT INTO LOCATION_MAPPING (ALIAS, STAGE, DESTINATION) VALUES ('BRA', 'PROD', 'http://bra-eai.internal.draexlmaier.com');