package cz.wincor.eps.cardhost.importer.impl.phillips66.dto;

/**
 * DTO pro ukládání rozparsovaných dat z tabulky Table-40
 */
public class CardDataDTO {

    private String customerCardType;
    private String hostCardType;
    private String paymentDescription;
    private String cobrandMsgFlag;
    private int timeOut;
    private String acceptFlag;
    private boolean manualEntry;
    private int authAmount;
    private boolean preAuthControlFlag;
    private boolean postEntryFlag;
    private boolean splitPaymentFlag;
    private boolean refundFlag;
    private String avsConfigFlag;
    private String cvnConfigFlag;
    private int standInLimit;
    private int presetForPump;
    private int signatureLimit;
    private String appliedDiscountFlag;
    private String amountPerGallonDiscount;
    private String percentDiscount;
    private String rtcFlag;

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

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public String getCobrandMsgFlag() {
        return cobrandMsgFlag;
    }

    public void setCobrandMsgFlag(String cobrandMsgFlag) {
        this.cobrandMsgFlag = cobrandMsgFlag;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getAcceptFlag() {
        return acceptFlag;
    }

    public void setAcceptFlag(String acceptFlag) {
        this.acceptFlag = acceptFlag;
    }

    public boolean getManualEntry() {
        return manualEntry;
    }

    public void setManualEntry(boolean manualEntry) {
        this.manualEntry = manualEntry;
    }

    public int getAuthAmount() {
        return authAmount;
    }

    public void setAuthAmount(int authAmount) {
        this.authAmount = authAmount;
    }

    public boolean getPreAuthControlFlag() {
        return preAuthControlFlag;
    }

    public void setPreAuthControlFlag(boolean preAuthControlFlag) {
        this.preAuthControlFlag = preAuthControlFlag;
    }

    public boolean getPostEntryFlag() {
        return postEntryFlag;
    }

    public void setPostEntryFlag(boolean postEntryFlag) {
        this.postEntryFlag = postEntryFlag;
    }

    public boolean getSplitPaymentFlag() {
        return splitPaymentFlag;
    }

    public void setSplitPaymentFlag(boolean splitPaymentFlag) {
        this.splitPaymentFlag = splitPaymentFlag;
    }

    public boolean getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(boolean refundFlag) {
        this.refundFlag = refundFlag;
    }

    public String getAvsConfigFlag() {
        return avsConfigFlag;
    }

    public void setAvsConfigFlag(String avsConfigFlag) {
        this.avsConfigFlag = avsConfigFlag;
    }

    public String getCvnConfigFlag() {
        return cvnConfigFlag;
    }

    public void setCvnConfigFlag(String cvnConfigFlag) {
        this.cvnConfigFlag = cvnConfigFlag;
    }

    public int getStandInLimit() {
        return standInLimit;
    }

    public void setStandInLimit(int standInLimit) {
        this.standInLimit = standInLimit;
    }

    public int getPresetForPump() {
        return presetForPump;
    }

    public void setPresetForPump(int presetForPump) {
        this.presetForPump = presetForPump;
    }

    public int getSignatureLimit() {
        return signatureLimit;
    }

    public void setSignatureLimit(int signatureLimit) {
        this.signatureLimit = signatureLimit;
    }

    public String getAppliedDiscountFlag() {
        return appliedDiscountFlag;
    }

    public void setAppliedDiscountFlag(String appliedDiscountFlag) {
        this.appliedDiscountFlag = appliedDiscountFlag;
    }

    public String getAmountPerGallonDiscount() {
        return amountPerGallonDiscount;
    }

    public void setAmountPerGallonDiscount(String amountPerGallonDiscount) {
        this.amountPerGallonDiscount = amountPerGallonDiscount;
    }

    public String getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(String percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public String getRtcFlag() {
        return rtcFlag;
    }

    public void setRtcFlag(String rtcFlag) {
        this.rtcFlag = rtcFlag;
    }
}
