package com.sachindramaharjan.catalogue.core.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
@Entity
@Table(name = "TBL_ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ACCOUNT_ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "DOB")
    private String dob;
    @Column(name = "SSN")
    private String ssn;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "ROUTING_NUMBER")
    private String routingNumber;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Instruction instruction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}
