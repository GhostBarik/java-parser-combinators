package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.cardData;


import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;
import cz.wincor.eps.cardhost.importer.impl.phillips66.dto.CardDataDTO;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.NumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.RepeatableParser;

import java.util.List;

/**
 * parser PDL tabulky s parametry karet (Table-40)
 */
public class CardDataTableParser implements BinaryParser<List<CardDataDTO>> {

    @Override
    public ParsingResult<List<CardDataDTO>> parse(ByteStream input) {

        // přečteme a zparsujeme počet karet, které máme načíst
        NumericParser numberOfCardsParser = new NumericParser(2);
        ParsingResult<Integer> result = numberOfCardsParser.parse(input);

        int numberOfCards = result.getResult();

        // zbytek rozprarsujeme opakovaným aplikováním parseru "CardDataParser"
        return (new RepeatableParser<>(new CardDataParser(), numberOfCards)).parse(result.getRestStream());
    }
}
