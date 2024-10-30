package com.example.test_api.account.converter;

import com.example.test_api.account.persistance.domain.Account;
import com.example.test_api.account.vo.AccountCreateVo;
import com.example.test_api.transaction.persistance.model.Transaction;
import com.example.test_api.transaction.vo.TransactionCreateVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AccountConverterService {

    public Account convertAccountCreateToAccount(AccountCreateVo vo) {
        Account model = new Account();
        model.setFullname(vo.getFullName());
        model.setEmail(vo.getEmail());
        model.setActive(true);
        model.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return model;
    }
}
