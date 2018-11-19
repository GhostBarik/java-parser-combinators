package cz.wincor.eps.cardhost.importer.impl.phillips66.parser;

/**
 * zakladní rozhrání parseru binárních dat
 */
public interface BinaryParser<T> {

    /**
     * parsování metoda, konzumuje vstupní stream dat
     * a vrácí výsledek parsování spolu se zbýtkem streamů
     * (posunutý o tolik bajtu, kolik bylo přečteno)
     *
     * @param input vstupní stream binárních dat
     *
     * @return výsledek parsování
     */
    ParsingResult<T> parse(ByteStream input);
}
