package org.khail.orderdomaine.Repository;

import org.khail.orderdomaine.Entitie.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrederRepository extends JpaRepository<Order ,Integer> {
}
