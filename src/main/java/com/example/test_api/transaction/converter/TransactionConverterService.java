package com.example.test_api.transaction.converter;

import com.example.test_api.transaction.persistance.model.Transaction;
import com.example.test_api.transaction.vo.TransactionCreateVo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TransactionConverterService {

    public Transaction convertTransactionCreateToTransaction(TransactionCreateVo vo) {
        Transaction model = new Transaction();
        model.setAccountId(vo.getAccountId());
        if (vo.getDestinationAccountId() != null) {
            model.setDestinationAccountId(vo.getDestinationAccountId());
        }
        if (vo.getAmount() != null) {
            model.setAmount(vo.getAmount().longValue());
        }
        model.setActive(true);
        model.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return model;
    }
}
