package com.sachindramaharjan.catalogue.core.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
@Entity
@Table(name = "TBL_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TRANSACTION_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account beneficiaryAccount;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "TRANSFER_MODE")
    private String transferMode;

    @ManyToOne
    @JoinColumn(name = "INSTR_ID")
    private Instruction instruction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(Account beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransferMode() {
        return transferMode;
    }

    public void setTransferMode(String transferMode) {
        this.transferMode = transferMode;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}
