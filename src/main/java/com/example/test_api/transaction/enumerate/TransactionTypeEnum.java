package com.example.test_api.transaction.enumerate;

public enum TransactionTypeEnum {
    DEPOSIT("DEPOSIT"),
    TRANSFER("TRANSFER"),
    WITHDRAW("WITHDRAW");

    private final String type;

    TransactionTypeEnum(String type) {
        this.type = type;
    }

    public String getInternalValue() {
        return type;
    }
}
