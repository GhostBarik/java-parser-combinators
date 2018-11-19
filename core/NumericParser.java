package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;

import java.util.Arrays;

/**
 * parsování celých čisel z bajtů
 */
public class NumericParser implements BinaryParser<Integer> {

    /**
     * kolik bajtů stačí přečíst ze vstupní binarní posloupnosti
     */
    private int bytesToRead;

    public NumericParser(int bytesToRead) {
        this.bytesToRead = bytesToRead;
    }

    @Override
    public ParsingResult<Integer> parse(ByteStream input) {

        byte[] chunk = Arrays.copyOfRange(
                input.getData(), input.getPosition(),
                input.getPosition() + bytesToRead
        );

        return new ParsingResult<>(
                Integer.parseInt(new String(chunk)),
                input.move(bytesToRead)
        );
    }
}
