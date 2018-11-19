package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * složený parser (kombinator), bere vzorový parser a aplikuje ho N-krát
 */
public class RepeatableParser<T> implements BinaryParser<List<T>> {

    /**
     * parser, který se má aplikovat opakovaně
     */
    private BinaryParser<T> elementParser;

    /**
     * kolikrat se má opakovat {@link RepeatableParser#elementParser}
     */
    private int timesRepeat;

    public RepeatableParser(BinaryParser<T> elementParser, int timesRepeat) {
        this.elementParser = elementParser;
        this.timesRepeat = timesRepeat;
    }

    @Override
    public ParsingResult<List<T>> parse(ByteStream input) {

        ByteStream currentStream = input;
        List<T> results = new ArrayList<>();

        for (int i = 0; i < timesRepeat; i++) {

            ParsingResult<T> result = elementParser.parse(currentStream);
            results.add(result.getResult());
            currentStream = result.getRestStream();
        }

        return new ParsingResult<>(results, currentStream);
    }
}
