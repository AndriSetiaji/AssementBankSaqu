package com.example.test_api.account.service;

import com.example.test_api.account.converter.AccountConverterService;
import com.example.test_api.account.persistance.domain.Account;
import com.example.test_api.account.persistance.repo.AccountRepo;
import com.example.test_api.account.vo.AccountCreateVo;
import com.example.test_api.balance.service.BalanceService;
import com.example.test_api.common.vo.ResponseVo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;
    private final BalanceService balanceService;
    private final AccountConverterService accountConverterService;

    public AccountService(AccountRepo accountRepo, BalanceService balanceService,
                          AccountConverterService accountConverterService) {
        this.accountRepo = accountRepo;
        this.balanceService = balanceService;
        this.accountConverterService = accountConverterService;
    }

    public ResponseVo createAccount(AccountCreateVo vo) {

        Account model = accountConverterService.convertAccountCreateToAccount(vo);
        model.setCreatedBy("create process");

        Account updated = accountRepo.save(model);
        balanceService.createBalance(updated.getId());

        ResponseVo res = new ResponseVo();
        res.setSuccess(true);
        return res;
    }

    public Account findById(Integer id) {
        Optional<Account> model = accountRepo.findById(id);
        return model.orElse(null);
    }
}
