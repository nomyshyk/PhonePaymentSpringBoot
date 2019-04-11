package kg.phone.paym.model;

import java.math.BigDecimal;

/**
 * @author kasiom
 */
public class PaymentRequest {
    private String phoneNo;
    private BigDecimal summa;

    public PaymentRequest(String phoneNo, BigDecimal summa) {
        this.phoneNo = phoneNo;
        this.summa = summa;
    }

    public PaymentRequest() {
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }
}
