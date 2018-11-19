 package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.binRanges;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;
import cz.wincor.eps.cardhost.importer.impl.phillips66.dto.BinRangeDTO;
import cz.wincor.eps.cardhost.importer.impl.phillips66.dto.CardBinRangesDTO;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.AlphanumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.NumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.RepeatableParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.SequenceParser;

import java.util.Arrays;
import java.util.List;

 /**
  * parser zaznamů BIN rangů pro jednotlivou kartu (tabulka Table-50)
  */
public class CardBinRangesParser implements BinaryParser<CardBinRangesDTO> {

    private List<BinaryParser<?>> fieldParsers = Arrays.<BinaryParser<?>>asList(

            new AlphanumericParser(2), // customerCardType
            new AlphanumericParser(2), // hostCardType
            new NumericParser(3)       // binRangesCount
    );

    @Override
    public ParsingResult<CardBinRangesDTO> parse(ByteStream input) {

        ParsingResult<List<Object>> parsedFields = new SequenceParser<>(fieldParsers).parse(input);

        List<Object> fields = parsedFields.getResult();

        String customerCardType = (String) fields.get(0);
        String hostCardType = (String) fields.get(1);
        int binRangesCount = (int) fields.get(2);

        CardBinRangesDTO resultDTO = new CardBinRangesDTO();
        resultDTO.setCustomerCardType(customerCardType);
        resultDTO.setHostCardType(hostCardType);

        ParsingResult<List<BinRangeDTO>> parsedBinRanges = (
                new RepeatableParser<>(new BinRangeParser(), binRangesCount)).parse(parsedFields.getRestStream()
        );

        resultDTO.setBinRanges(parsedBinRanges.getResult());

        return new ParsingResult<>(resultDTO, parsedBinRanges.getRestStream());
    }
}
