package io.bayrktlihn.bookstorewebsite.repository;

import io.bayrktlihn.bookstorewebsite.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    boolean existsByName(String name);

}
