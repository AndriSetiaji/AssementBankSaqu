package com.example.test_api.transaction.service;

import com.example.test_api.account.persistance.domain.Account;
import com.example.test_api.account.service.AccountService;
import com.example.test_api.balance.service.BalanceService;
import com.example.test_api.common.service.RabbitMQSender;
import com.example.test_api.common.vo.ResponseVo;
import com.example.test_api.transaction.converter.TransactionConverterService;
import com.example.test_api.transaction.enumerate.TransactionTypeEnum;
import com.example.test_api.transaction.persistance.model.Transaction;
import com.example.test_api.transaction.persistance.repo.TransactionRepo;
import com.example.test_api.transaction.vo.TransactionCreateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    Logger logger = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepo transactionRepo;
    private final AccountService accountService;
    private final BalanceService balanceService;
    private final TransactionConverterService transactionConverterService;
    private final RabbitMQSender rabbitMQSender;

    public TransactionService(TransactionRepo transactionRepo, AccountService accountService,
                              BalanceService balanceService, TransactionConverterService transactionConverterService,
                              RabbitMQSender rabbitMQSender) {
        this.transactionRepo = transactionRepo;
        this.accountService = accountService;
        this.balanceService = balanceService;
        this.transactionConverterService = transactionConverterService;
        this.rabbitMQSender = rabbitMQSender;
    }

    public ResponseVo deposit(TransactionCreateVo vo) {
        Account account = accountService.findById(vo.getAccountId());
        balanceService.deposit(account.getId(), vo.getAmount());

        Transaction model = transactionConverterService.convertTransactionCreateToTransaction(vo);
        model.setTransactionType(TransactionTypeEnum.DEPOSIT.getInternalValue());
        model.setCreatedBy("deposit process");
        Transaction transaction = transactionRepo.save(model);
        rabbitMQSender.send(transaction);

        logger.info(transaction.toString());

        ResponseVo res = new ResponseVo();
        res.setSuccess(true);
        return res;
    }

    public ResponseVo withdraw(TransactionCreateVo vo) {
        Account account = accountService.findById(vo.getAccountId());
        balanceService.withdraw(account.getId(), vo.getAmount());

        Transaction model = transactionConverterService.convertTransactionCreateToTransaction(vo);
        model.setTransactionType(TransactionTypeEnum.WITHDRAW.getInternalValue());
        model.setCreatedBy("withdraw process");
        Transaction transaction = transactionRepo.save(model);
        rabbitMQSender.send(transaction);
        logger.info(transaction.toString());
        ResponseVo res = new ResponseVo();
        res.setSuccess(true);
        return res;
    }

    public ResponseVo transfer(TransactionCreateVo vo) {

        Account account = accountService.findById(vo.getAccountId());
        Account destinationAccount = accountService.findById(vo.getDestinationAccountId());

        balanceService.transfer(account.getId(), destinationAccount.getId(), vo.getAmount());

        Transaction model = transactionConverterService.convertTransactionCreateToTransaction(vo);
        model.setTransactionType(TransactionTypeEnum.TRANSFER.getInternalValue());
        model.setCreatedBy("transfer process");
        Transaction transaction = transactionRepo.save(model);
        rabbitMQSender.send(transaction);
        logger.info(transaction.toString());
        ResponseVo res = new ResponseVo();
        res.setSuccess(true);
        return res;
    }
}
