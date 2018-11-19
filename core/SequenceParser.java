package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core;


import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * složený parser (kombinator), bere seznam seznam parserů a
 * postupně aplikuje jeden po druhým na vstupním streamů bajtů
 */
public class SequenceParser<T> implements BinaryParser<List<T>> {

    /**
     * seznam parserů, které se mají aplikovat jeden po druhým
     */
    private List<BinaryParser<? extends T>> parsers;

    public SequenceParser(List<BinaryParser<? extends T>> parsers) {
        this.parsers = parsers;
    }

    @Override
    public ParsingResult<List<T>> parse(ByteStream input) {

        ByteStream currentStream = input;
        List<T> results = new ArrayList<>();

        for (BinaryParser<? extends T> parser : parsers) {

            ParsingResult<? extends T> result = parser.parse(currentStream);
            results.add(result.getResult());
            currentStream = result.getRestStream();
        }

        return new ParsingResult<>(results, currentStream);
    }
}
