package kg.phone.paym.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author kasiom
 */
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private BigDecimal summa;
    private String status;
    private LocalDateTime dateCreated;

    public Payment(Client client, BigDecimal summa, String status) {
        this.client = client;
        this.summa = summa;
        this.status = status;
        this.dateCreated = LocalDateTime.now();
    }

    public Payment(Client client, BigDecimal summa) {
        this.client = client;
        this.summa = summa;
        this.dateCreated = LocalDateTime.now();
        if(this.summa.remainder(BigDecimal.valueOf(2))
                .equals(BigDecimal.ZERO)){
            this.status = "SUCCESS";
        } else{
            this.status = "ERROR";
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment() {
        this.dateCreated = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
