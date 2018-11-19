package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.exeption;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;

/**
 * výjimka, která se vyhazuje při selhání parserů {@link BinaryParser}
 */
public class ParsingException extends RuntimeException {

    public ParsingException() {
        super();
    }

    public ParsingException(String message) {
        super(message);
    }

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParsingException(Throwable cause) {
        super(cause);
    }
}
