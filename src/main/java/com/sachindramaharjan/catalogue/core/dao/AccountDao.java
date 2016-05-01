package com.sachindramaharjan.catalogue.core.dao;

import com.sachindramaharjan.catalogue.core.entity.Account;
import com.sachindramaharjan.catalogue.core.entity.Bank;
import com.sachindramaharjan.catalogue.core.entity.User;
import sun.security.x509.GeneralNameInterface;

import java.util.List;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
public interface AccountDao<T extends Account> extends GenericDaoInterface<Account> {

    Account findAccountByUser(User user);

    List<Account> findAccountByBank(Bank bank);

    Account findAccountByCombination(String lastname, String dob, String ssn);

}
