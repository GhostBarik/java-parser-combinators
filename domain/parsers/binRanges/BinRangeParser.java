package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.binRanges;


import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;
import cz.wincor.eps.cardhost.importer.impl.phillips66.dto.BinRangeDTO;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.AlphanumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.BooleanParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.SequenceParser;

import java.util.Arrays;
import java.util.List;

/**
 * parser jednotlivých zaznamu z PDL tabulky BIN rangů (Table-50)
 */
public class BinRangeParser implements BinaryParser<BinRangeDTO> {

    private List<BinaryParser<?>> fieldParsers = Arrays.<BinaryParser<?>>asList(

            new AlphanumericParser(19), // binStart
            new BooleanParser(1),       // debitCapable
            new AlphanumericParser(19)  // binEnd
    );

    @Override
    public ParsingResult<BinRangeDTO> parse(ByteStream input) {

        BinRangeDTO resultDTO = new BinRangeDTO();

        ParsingResult<List<Object>> parsedFields = new SequenceParser<>(fieldParsers).parse(input);
        List<Object> fields = parsedFields.getResult();

        resultDTO.setBinStart((String) fields.get(0));
        resultDTO.setDebitCapable((boolean) fields.get(1));
        resultDTO.setBinEnd((String) fields.get(2));

        return new ParsingResult<>(resultDTO, parsedFields.getRestStream());
    }
}
