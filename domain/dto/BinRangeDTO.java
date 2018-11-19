package cz.wincor.eps.cardhost.importer.impl.phillips66.dto;

/**
 * DTO pro ukládání rozparsovaných dat z tabulky Table-50
 */
public class BinRangeDTO {

    private String binStart;
    private boolean debitCapable;
    private String binEnd;

    public String getBinStart() {
        return binStart;
    }

    public void setBinStart(String binStart) {
        this.binStart = binStart;
    }

    public boolean getDebitCapable() {
        return debitCapable;
    }

    public void setDebitCapable(boolean debitCapable) {
        this.debitCapable = debitCapable;
    }

    public String getBinEnd() {
        return binEnd;
    }

    public void setBinEnd(String binEnd) {
        this.binEnd = binEnd;
    }
}
