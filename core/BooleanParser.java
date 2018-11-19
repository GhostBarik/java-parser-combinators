package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.exeption.ParsingException;

import java.util.Arrays;

/**
 * parsování booleanů z bajtů
 */
public class BooleanParser implements BinaryParser<Boolean> {

    /**
     * kolik bajtů stačí přečíst ze vstupní binarní posloupnosti
     */
    private int bytesToRead;

    public BooleanParser(int bytesToRead) {
        this.bytesToRead = bytesToRead;
    }

    @Override
    public ParsingResult<Boolean> parse(ByteStream input) {

        byte[] chunk = Arrays.copyOfRange(
                input.getData(), input.getPosition(),
                input.getPosition() + bytesToRead
        );

        boolean result;

        String test = new String(chunk);

        if ("1".equals(test)) {
            result = true;
        } else if ("0".equals(test)) {
            result = false;
        } else {
            throw new ParsingException("cannot extract boolean from string: " + test);
        }

        return new ParsingResult<>(result, input.move(bytesToRead));
    }
}
