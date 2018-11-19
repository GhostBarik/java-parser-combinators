package cz.wincor.eps.cardhost.importer.impl.phillips66.dto;

import java.util.List;

/**
 * DTO pro ukládání rozparsovaných dat z tabulky Table-50
 */
public class CardBinRangesDTO {

    private String customerCardType;
    private String hostCardType;

    private List<BinRangeDTO> binRanges;

    public String getCustomerCardType() {
        return customerCardType;
    }

    public void setCustomerCardType(String customerCardType) {
        this.customerCardType = customerCardType;
    }

    public String getHostCardType() {
        return hostCardType;
    }

    public void setHostCardType(String hostCardType) {
        this.hostCardType = hostCardType;
    }

    public List<BinRangeDTO> getBinRanges() {
        return binRanges;
    }

    public void setBinRanges(List<BinRangeDTO> binRanges) {
        this.binRanges = binRanges;
    }
}
