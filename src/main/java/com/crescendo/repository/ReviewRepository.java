package com.crescendo.repository;

import com.crescendo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<List<Review>> getAllByBusinessId(Long businessId);

    @Modifying
    void deleteByBusinessId(Long businessId);
}
