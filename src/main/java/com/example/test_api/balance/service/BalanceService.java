package com.example.test_api.balance.service;

import com.example.test_api.balance.persistance.model.Balance;
import com.example.test_api.balance.persistance.repo.BalanceRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {

    private final BalanceRepo balanceRepo;

    public BalanceService(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    public Balance createBalance(Integer accountId) {
        Balance model = new Balance();
        model.setAccountId(accountId);
        model.setRemainingBalance(0L);
        model.setActive(true);
        model.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("create process");
        return balanceRepo.save(model);
    }

    public Balance deposit(Integer accountId, Integer amount) {
        Optional<Balance> balanceOpt = balanceRepo.findByAccountId(accountId);
        if (balanceOpt.isEmpty()) {
            return null;
        }
        Balance model = balanceOpt.get();
        Long remainingBalance = model.getRemainingBalance() + amount;

        model.setRemainingBalance(remainingBalance);

        model.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
        model.setLastUpdatedBy("deposit process");
        return balanceRepo.save(model);
    }

    public Balance withdraw(Integer accountId, Integer amount) {
        Optional<Balance> balanceOpt = balanceRepo.findByAccountId(accountId);
        if (balanceOpt.isEmpty()) {
            return null;
        }
        Balance model = balanceOpt.get();
        if (model.getRemainingBalance() < amount) {
            throw new RuntimeException("Error");
        }
        Long remainingBalance = model.getRemainingBalance() - amount;

        model.setRemainingBalance(remainingBalance);

        model.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
        model.setLastUpdatedBy("withdraw process");
        return balanceRepo.save(model);
    }

    public List<Balance> transfer(Integer accountId, Integer destinationAccountId, Integer amount) {
        List<Balance> models = new ArrayList<>();

        Optional<Balance> balanceOpt = balanceRepo.findByAccountId(destinationAccountId);
        if (balanceOpt.isEmpty()) {
            return null;
        }
        Balance model = balanceOpt.get();
        long remainingBalance = model.getRemainingBalance() + amount;

        model.setRemainingBalance(remainingBalance);

        model.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
        model.setLastUpdatedBy("transfer process");
        models.add(model);

        balanceOpt = balanceRepo.findByAccountId(accountId);
        if (balanceOpt.isEmpty()) {
            return null;
        }
        model = balanceOpt.get();
        if (model.getRemainingBalance() < amount) {
            throw new RuntimeException("Error");
        }
        remainingBalance = model.getRemainingBalance() - amount;

        model.setRemainingBalance(remainingBalance);

        model.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));
        model.setLastUpdatedBy("withdraw process");
        models.add(model);
        balanceRepo.saveAll(models);
        return models;
    }
}
