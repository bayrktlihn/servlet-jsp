package io.bayrktlihn.bookstorewebsite.repository;

import java.util.List;

public interface JpaRepository<TENTITY, TID> {

    List<TENTITY> findAll();

    TENTITY findById(TID id);

    TENTITY save(TENTITY entity);

    void delete(TENTITY entity);

    void deleteById(TID id);

    long count();

}
