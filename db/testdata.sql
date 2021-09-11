INSERT INTO EXPRESSION (ID, EXP, EXPECTED_VALUE, EXPECTED_TYPE) VALUES (1, 'bookstore/book[@category=''cooking'']/title', 'Everyday Italian', 'STRING');
INSERT INTO EXPRESSION (ID, EXP, EXPECTED_VALUE, EXPECTED_TYPE) VALUES (2, 'bookstore/book[@category=''children'']/title', 'Harry Potter', 'STRING');
INSERT INTO EXPRESSION (ID, EXP, EXPECTED_VALUE, EXPECTED_TYPE) VALUES (3, 'bookstore/book[@category=''children'']/year', '2005', 'NUMBER');
INSERT INTO EXPRESSION (ID, EXP, EXPECTED_VALUE, EXPECTED_TYPE) VALUES (4, 'bookstore/book[@category=''cooking'']/available', 'true', 'BOOLEAN');
INSERT INTO EXPRESSION (ID, EXP, EXPECTED_VALUE, EXPECTED_TYPE) VALUES (5, 'bookstore/book[@category=''children'']/price', '29.99', 'NUMBER');

INSERT INTO DOCUMENT_MAPPING (ID, DOCUMENT_NAME, DOCUMENT_TYPE, EXPRESSION_1, EXPRESSION_2, EXPRESSION_3, EXPRESSION_4, EXPRESSION_5) VALUES (1, 'Books', 'XML', 1, 2, 3, 4, 5);

