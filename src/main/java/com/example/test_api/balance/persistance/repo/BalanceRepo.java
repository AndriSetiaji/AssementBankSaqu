package com.example.test_api.balance.persistance.repo;

import com.example.test_api.balance.persistance.model.Balance;
import com.example.test_api.common.persistance.repo.BaseRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BalanceRepo extends BaseRepo<Balance, Integer> {

    @Query("""
            SELECT t FROM Balance t
            WHERE t.isActive = true
            AND t.accountId = :id
            """
    )
    Optional<Balance> findByAccountId(
            @Param("id") Integer id
    );
}