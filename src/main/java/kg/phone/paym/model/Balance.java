package kg.phone.paym.model;

import java.math.BigDecimal;

/**
 * @author kasiom
 */
public class Balance {
    private Client client;
    private BigDecimal balance;

    public Balance(Client client, BigDecimal balance) {
        this.client = client;
        this.balance = balance;
    }

    public Balance() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
