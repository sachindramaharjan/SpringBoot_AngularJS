package com.sachindramaharjan.catalogue.core.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
@Entity
@Table(name = "TBL_BANK")
public class Bank {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "BANK_ID")
    private Long id;
    @Column(name = "BANK_NAME")
    private String name;
    @Column(name = "BANK_CODE")
    private String bankCode;
    @Column(name = "SWIFT_CODE")
    private String swiftCode;
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
