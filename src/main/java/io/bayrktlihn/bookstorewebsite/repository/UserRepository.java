package io.bayrktlihn.bookstorewebsite.repository;

import io.bayrktlihn.bookstorewebsite.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long id);

    boolean checkPassword(String email, String password);

}
