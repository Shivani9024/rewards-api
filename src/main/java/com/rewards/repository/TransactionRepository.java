package com.rewards.repository;

import com.rewards.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepository {

    public List<Transaction> findAll() {
        return List.of(
                new Transaction(1L, 1L, 120, LocalDate.now().minusMonths(1)),
                new Transaction(2L, 1L, 75, LocalDate.now().minusMonths(2)),
                new Transaction(3L, 2L, 200, LocalDate.now().minusMonths(1)),
                new Transaction(4L, 2L, 40, LocalDate.now().minusMonths(3))
        );
    }
}
