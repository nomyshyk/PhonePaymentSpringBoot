package kg.phone.paym.repository;

import kg.phone.paym.model.Client;
import kg.phone.paym.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author kasiom
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p join fetch p.client c " +
            "where c.id = :clientId")
    List<Payment> getClientPayments(@Param("clientId") Long clientId);

    @Query("select p from Payment p join fetch p.client c " +
            "where c.phoneNo = coalesce(:phoneNo, c.phoneNo) " +
            "and c.fio = coalesce(:fio, c.fio) " +
            "and p.status = coalesce(:status, p.status) " +
            "")
    List<Payment> getPaymentsByParam(@Param("phoneNo") String phoneNo,
                                     @Param("fio") String fio,
                                     @Param("status") String status);
}
