package com.rewards.controller;

import com.rewards.dto.RewardResponse;
import com.rewards.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService service;

    public RewardController(RewardService service) {
        this.service = service;
    }

    @GetMapping
    public List<RewardResponse> getRewards() {
        return service.calculateRewards();
    }
}
