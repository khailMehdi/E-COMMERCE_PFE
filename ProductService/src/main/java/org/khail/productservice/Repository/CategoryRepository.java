package org.khail.productservice.Repository;

import org.khail.productservice.Entitie.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
