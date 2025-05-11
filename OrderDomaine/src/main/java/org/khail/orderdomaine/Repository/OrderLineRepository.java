package org.khail.orderdomaine.Repository;

import org.khail.orderdomaine.Entitie.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
}
