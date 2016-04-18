package com.sachindramaharjan.catalogue.core.entity;

import com.sun.tools.javac.jvm.Gen;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
@Entity
@Table(name = "TBL_INSTR")
public class Instruction {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "INSTR_ID")
    private Long id;

    @Column(name = "INSTR_NAME")
    private String instrName;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @Column(name = "INSTR_TYPE")
    private String instrType;

    @Column(name = "INSTR_DESC")
    private String instrDescrition;

    @OneToMany(mappedBy = "instruction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrName() {
        return instrName;
    }

    public void setInstrName(String instrName) {
        this.instrName = instrName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccountId(Account accountId) {
        this.account = accountId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getInstrType() {
        return instrType;
    }

    public void setInstrType(String instrType) {
        this.instrType = instrType;
    }

    public String getInstrDescrition() {
        return instrDescrition;
    }

    public void setInstrDescrition(String instrDescrition) {
        this.instrDescrition = instrDescrition;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
