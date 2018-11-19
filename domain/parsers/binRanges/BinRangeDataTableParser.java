package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.binRanges;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;
import cz.wincor.eps.cardhost.importer.impl.phillips66.dto.CardBinRangesDTO;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.NumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.RepeatableParser;

import java.util.List;

/**
 * parser jednotlivých zaznamu z PDL tabulky BIN rangů (Table-50)
 */
public class BinRangeDataTableParser implements BinaryParser<List<CardBinRangesDTO>> {

    @Override
    public ParsingResult<List<CardBinRangesDTO>> parse(ByteStream input) {

        // přečteme a zparsujeme počet skupin BIN rangů pro jednotlivé karty, které máme načíst
        NumericParser numberOfCardsParser = new NumericParser(2);
        ParsingResult<Integer> result = numberOfCardsParser.parse(input);

        int numberOfCards = result.getResult();

        // zbytek rozprarsujeme opakovaným aplikováním parseru "CardBinRangesParser"
        return (new RepeatableParser<>(new CardBinRangesParser(), numberOfCards)).parse(result.getRestStream());
    }
}
