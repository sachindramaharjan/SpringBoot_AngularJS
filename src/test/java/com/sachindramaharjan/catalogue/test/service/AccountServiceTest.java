package com.sachindramaharjan.catalogue.test.service;

import com.sachindramaharjan.catalogue.core.dao.BankDao;
import com.sachindramaharjan.catalogue.core.dao.UserDao;
import com.sachindramaharjan.catalogue.core.entity.Account;
import com.sachindramaharjan.catalogue.core.entity.Bank;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.service.AccountService;
import com.sachindramaharjan.catalogue.test.SpringTestConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
@Transactional
public class AccountServiceTest extends SpringTestConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(Account.class);

    @Autowired
    AccountService accountService;

    @Autowired
    BankDao bankDao;

    @Autowired
    UserDao userDao;

    Account account = null;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUsername("test1");
        user.setPassword("password");
        user.setEmail("test1@gmail.com");
        user.setActivate_fl(true);

        Bank bank = new Bank();
        bank.setName("HSBC");
        bank.setBankCode("AB22423");
        bank.setSwiftCode("12345");

        account = new Account();
        account.setFirstname("Sachindra");
        account.setLastname("Maharjan");
        account.setBank(bank);
        account.setUser(user);
        account.setDob("01/01/1994");
        account.setSsn("111-11-111");
        account.setCurrency("US");
        account.setBalance(new BigDecimal(123456.99));
        account.setRoutingNumber(3232342L);
        account.setAccountNumber(1234556L);

        user.setAccount(account);

    }

    @Test
    public void testAccountCreate() throws Exception {
        Account newAccount = accountService.create(account);

        Assert.assertNotNull(newAccount);
        Assert.assertNotNull(newAccount.getUser());
        Assert.assertNotNull(newAccount.getBank());
        Assert.assertEquals(newAccount.getAccountNumber(), account.getAccountNumber());

    }

    @Test
    public void testAccountUpdate() throws Exception {
        Account newAccount = accountService.findByID(10L);
        newAccount.setBalance(new BigDecimal(9999.99));
        newAccount.setCurrency("EUR");
        Account updateAccount = accountService.update(newAccount);

        Assert.assertNotNull(updateAccount);
        Assert.assertNotNull(updateAccount.getBank());
        Assert.assertEquals("EUR", updateAccount.getCurrency());
    }

    @Test
    public void testAccountDelete() throws Exception{
        Account newAccount = accountService.findByID(10L);
        boolean flag = accountService.delete(newAccount);

        Assert.assertEquals(true, flag);
        Assert.assertNull(accountService.findByID(10L));
    }


    @Test
    public void testFindAccountByCombination() throws Exception{
        accountService.create(account);
        Account findAccount = accountService.findAccountByCombination("Maharjan", "01/01/1994", "111-11-111");
        Assert.assertNotNull(findAccount);
    }

}
