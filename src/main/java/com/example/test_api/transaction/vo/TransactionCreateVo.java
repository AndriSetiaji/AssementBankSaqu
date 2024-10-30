package com.example.test_api.transaction.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionCreateVo {
    private Integer accountId;
    private Integer destinationAccountId;
    private Integer amount;
    private String transactionType;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(Integer destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
