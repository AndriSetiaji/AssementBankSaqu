package com.example.test_api.balance.persistance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "remaining_balance")
    private Long remainingBalance;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_updated_at")
    private Date lastUpdatedAt;
    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Long getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(Long remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
