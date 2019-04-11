package kg.phone.paym.repository;

import kg.phone.paym.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

/**
 * @author kasiom
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select sum(p.summa) from Payment p inner join p.client c " +
            "where c.id = :clientId ")
    BigDecimal getBalance(@Param("clientId") Long clientId);

    @Query("select c from Client c where c.phoneNo = :phoneNo")
    Client getClientByPhoneNo(@Param("phoneNo") String phoneNo);
}
