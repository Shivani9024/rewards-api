package com.rewards.service;

import com.rewards.dto.RewardResponse;
import com.rewards.model.Transaction;
import com.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.*;

@Service
public class RewardService {

    private final TransactionRepository repository;

    public RewardService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<RewardResponse> calculateRewards() {
        Map<Long, List<Transaction>> grouped = new HashMap<>();
        for (Transaction t : repository.findAll()) {
            grouped.computeIfAbsent(t.getCustomerId(), k -> new ArrayList<>()).add(t);
        }

        List<RewardResponse> responses = new ArrayList<>();

        for (Long customerId : grouped.keySet()) {
            Map<String, Integer> monthly = new HashMap<>();
            int total = 0;

            for (Transaction t : grouped.get(customerId)) {
                int points = calculatePoints(t.getAmount());
                String month = t.getDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                monthly.put(month, monthly.getOrDefault(month, 0) + points);
                total += points;
            }

            responses.add(new RewardResponse(customerId, monthly, total));
        }

        return responses;
    }

    public int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (int)((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (int)(amount - 50);
        }
        return points;
    }
}
