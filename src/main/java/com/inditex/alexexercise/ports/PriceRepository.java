package com.inditex.alexexercise.ports;


import com.inditex.alexexercise.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p JOIN p.brand b " +
            "" +
            "WHERE b.id = ?1 AND p.productId = ?2 " +
            "AND (?3 BETWEEN p.startDate AND p.endDate) ORDER BY p.priority ASC")
    List<Price> findByProductAndDate(Long brandId, Long productId, LocalDateTime appDate);

}
