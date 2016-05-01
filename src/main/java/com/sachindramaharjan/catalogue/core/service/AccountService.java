package com.sachindramaharjan.catalogue.core.service;

import com.sachindramaharjan.catalogue.core.entity.Account;

import java.util.List;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
public interface AccountService {

    Account create(Account account);

    Account update(Account account);

    boolean delete(Account account);

    Account findByID(Long accountID);

    Account findAccountByUserID(String userID);

    List<Account> findAccountByBankId(Long bankID);

    Account findAccountByCombination(String lastname, String dob, String ssn);

}
