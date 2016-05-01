package com.sachindramaharjan.catalogue.core.daoImpl;

import com.sachindramaharjan.catalogue.core.dao.AccountDao;
import com.sachindramaharjan.catalogue.core.dao.BankDao;
import com.sachindramaharjan.catalogue.core.dao.UserDao;
import com.sachindramaharjan.catalogue.core.entity.Account;
import com.sachindramaharjan.catalogue.core.entity.Bank;
import com.sachindramaharjan.catalogue.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao<Account> {

    private static final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);

    private String hqlQuery;

    public AccountDaoImpl(){
        super(Account.class);
    }

    @Override
    public Account findAccountByUser(User user) {
        try {
            hqlQuery = "SELECT a FROM Account a WHERE a.user = :user";
            TypedQuery<Account> query = entityManager.createQuery(hqlQuery, Account.class);
            query.setParameter("user", user);
            return query.getSingleResult();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Account> findAccountByBank(Bank bank) {
        try {
            hqlQuery = "SELECT a FROM Account a WHERE a.bank = :bank";
            TypedQuery<Account> query = entityManager.createQuery(hqlQuery, Account.class);
            query.setParameter("bank", bank);
            return query.getResultList();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public Account findAccountByCombination(String lastname, String dob, String ssn) {
        try{
            hqlQuery = "SELECT a from Account a WHERE a.lastname = :lastname and a.dob = :dob and a.ssn = :ssn";
            TypedQuery<Account> query = entityManager.createQuery(hqlQuery, Account.class);
            query.setParameter("lastname", lastname);
            query.setParameter("dob", dob);
            query.setParameter("ssn", ssn);
            return query.getSingleResult();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
