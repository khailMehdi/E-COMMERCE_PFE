package org.khail.customerservice.Repository;

import org.khail.customerservice.Entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("select c from Customer c where (c.firstName like %:kw%) " +
            "or (c.lastName like %:kw%) or (c.email like %:kw%)")
    List<Customer> searchCustomers(@Param("kw") String kw);

    List<Customer> findByEmail(String email);
    List<Customer> findByFirstName(String firstName);


}
