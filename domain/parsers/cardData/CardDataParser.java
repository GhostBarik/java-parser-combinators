package cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.cardData;

import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.BinaryParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ByteStream;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.ParsingResult;
import cz.wincor.eps.cardhost.importer.impl.phillips66.dto.CardDataDTO;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.AlphanumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.BooleanParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.NumericParser;
import cz.wincor.eps.cardhost.importer.impl.phillips66.parser.impl.core.SequenceParser;

import java.util.Arrays;
import java.util.List;

/**
 * parser jednotlivých zaznamu z PDL tabulky parametrů karet (Table-40)
 */
public class CardDataParser implements BinaryParser<CardDataDTO> {

    private List<BinaryParser<?>> fieldParsers = Arrays.<BinaryParser<?>>asList(

            new AlphanumericParser(2), // customerCardType
            new AlphanumericParser(2), // hostCardType
            new AlphanumericParser(9), // paymentDescription
            new AlphanumericParser(1), // cobrandMsgFlag
            new NumericParser(2),      // timeOut
            new AlphanumericParser(1), // acceptFlag
            new BooleanParser(1),      // manualEntry
            new NumericParser(4),      // authAmount
            new BooleanParser(1),      // preAuthControlFlag
            new BooleanParser(1),      // postEntryFlag
            new BooleanParser(1),      // splitPaymentFlag
            new BooleanParser(1),      // refundFlag
            new AlphanumericParser(1), // avsConfigFlag
            new AlphanumericParser(1), // cvnConfigFlag
            new NumericParser(3),      // standInLimit
            new NumericParser(4),      // presetForPump
            new NumericParser(2),      // signatureLimit
            new AlphanumericParser(1), // appliedDiscountFlag
            new AlphanumericParser(4), // amountPerGallonDiscount
            new AlphanumericParser(4), // percentDiscount
            new AlphanumericParser(1)  // rtcFlag
    );

    @Override
    public ParsingResult<CardDataDTO> parse(ByteStream input) {

        CardDataDTO resultDTO = new CardDataDTO();

        ParsingResult<List<Object>> parsedFields = new SequenceParser<>(fieldParsers).parse(input);
        List<Object> fields = parsedFields.getResult();

        resultDTO.setCustomerCardType((String) fields.get(0));
        resultDTO.setHostCardType((String) fields.get(1));
        resultDTO.setPaymentDescription((String) fields.get(2));
        resultDTO.setCobrandMsgFlag((String) fields.get(3));
        resultDTO.setTimeOut((int) fields.get(4));
        resultDTO.setAcceptFlag((String) fields.get(5));
        resultDTO.setManualEntry((boolean) fields.get(6));
        resultDTO.setAuthAmount((int) fields.get(7));
        resultDTO.setPreAuthControlFlag((boolean) fields.get(8));
        resultDTO.setPostEntryFlag((boolean) fields.get(9));
        resultDTO.setSplitPaymentFlag((boolean) fields.get(10));
        resultDTO.setRefundFlag((boolean) fields.get(11));
        resultDTO.setAvsConfigFlag((String) fields.get(12));
        resultDTO.setCvnConfigFlag((String) fields.get(13));
        resultDTO.setStandInLimit((int) fields.get(14));
        resultDTO.setPresetForPump((int) fields.get(15));
        resultDTO.setSignatureLimit((int) fields.get(16));
        resultDTO.setAppliedDiscountFlag((String) fields.get(17));
        resultDTO.setAmountPerGallonDiscount((String) fields.get(18));
        resultDTO.setPercentDiscount((String) fields.get(19));
        resultDTO.setRtcFlag((String) fields.get(20));

        return new ParsingResult<>(resultDTO, parsedFields.getRestStream());
    }
}
