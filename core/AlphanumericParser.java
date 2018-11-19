package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;

import java.util.Arrays;
import java.util.Map;

/**
 * parsování alphanumerické posloupnosti znaků do Stringu
 */
public class AlphanumericParser implements BinaryParser<String> {

    /**
     * kolik bajtů stačí přečíst ze vstupní binarní posloupnosti
     */
    private int bytesToRead;

    public AlphanumericParser(int bytesToRead) {
        this.bytesToRead = bytesToRead;
    }

    @Override
    public ParsingResult<String> parse(ByteStream input) {

        byte[] chunk = Arrays.copyOfRange(
                input.getData(), input.getPosition(),
                input.getPosition() + bytesToRead
        );

        return new ParsingResult<>(
                new String(chunk),
                input.move(bytesToRead)
        );
    }
}
