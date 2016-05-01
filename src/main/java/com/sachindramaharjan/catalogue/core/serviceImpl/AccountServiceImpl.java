package com.sachindramaharjan.catalogue.core.serviceImpl;

import com.sachindramaharjan.catalogue.core.dao.AccountDao;
import com.sachindramaharjan.catalogue.core.dao.BankDao;
import com.sachindramaharjan.catalogue.core.dao.UserDao;
import com.sachindramaharjan.catalogue.core.entity.Account;
import com.sachindramaharjan.catalogue.core.entity.Bank;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.exception.AccountExistException;
import com.sachindramaharjan.catalogue.core.exception.NotFoundException;
import com.sachindramaharjan.catalogue.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BankDao bankDao;

    @Override
    public Account create(Account account) {
        if(accountDao.findAccountByCombination(account.getLastname(), account.getDob(), account.getSsn()) != null){
            throw new AccountExistException("Account already exist with "+
                    "lastname = " + account.getLastname() +
                    "date of birth = " + account.getDob() +
                    "SSN = " + account.getSsn());
        }

        return (Account)accountDao.save(account);
    }

    @Override
    public Account update(Account account) {
        if(accountDao.find(account.getId()) == null){
            throw new AccountExistException("Accound does not exists");
        }

        return (Account)accountDao.update(account);
    }

    @Override
    public boolean delete(Account account) {
        if(accountDao.find(account.getId()) == null){
            throw new AccountExistException("Accound does not exists");
        }

        return accountDao.delete(account);
    }

    @Override
    public Account findByID(Long accountID) {
        return (Account) accountDao.find(accountID);
    }

    @Override
    public Account findAccountByUserID(String userID) {
        User user = (User)userDao.find(userID);
        if(user == null) {
            throw new NotFoundException("User not found");
        }

        return accountDao.findAccountByUser(user);
    }

    @Override
    public List<Account> findAccountByBankId(Long bankID) {
        Bank bank = (Bank) bankDao.find(bankID);
        if(bank == null){
            throw new NotFoundException("Bank not found");
        }

        return accountDao.findAccountByBank(bank);
    }

    @Override
    public Account findAccountByCombination(String lastname, String dob, String ssn) {
        return accountDao.findAccountByCombination(lastname, dob, ssn);
    }
}
