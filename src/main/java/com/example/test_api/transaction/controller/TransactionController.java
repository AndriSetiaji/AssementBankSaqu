package com.example.test_api.transaction.controller;

import com.example.test_api.account.service.AccountService;
import com.example.test_api.account.vo.AccountCreateVo;
import com.example.test_api.common.vo.ResponseVo;
import com.example.test_api.transaction.service.TransactionService;
import com.example.test_api.transaction.vo.TransactionCreateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/deposit")
    ResponseVo deposit(@RequestBody TransactionCreateVo vo) {
        return transactionService.deposit(vo);
    }

    @PostMapping("/withdraw")
    ResponseVo withdraw(@RequestBody TransactionCreateVo vo) {
        return transactionService.withdraw(vo);
    }

    @PostMapping("/transfer")
    ResponseVo transfer(@RequestBody TransactionCreateVo vo) {
        return transactionService.transfer(vo);
    }
}
