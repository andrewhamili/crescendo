package com.crescendo.repository;

import com.crescendo.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    @Modifying
    void deleteById(Long id);

}
