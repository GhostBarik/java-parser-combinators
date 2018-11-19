package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;

/**
 * Created by barabash on 11/30/15.
 */
public class CharacterParser implements BinaryParser<Character> {

    @Override
    public ParsingResult<Character> parse(ByteStream input) {
        return new ParsingResult<>((char) input.getData()[input.getPosition()], input.move(1));
    }
}
