package com.sachindramaharjan.catalogue.core.daoImpl;

import com.sachindramaharjan.catalogue.core.dao.BankDao;
import com.sachindramaharjan.catalogue.core.entity.Bank;
import org.springframework.stereotype.Repository;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
@Repository
public class BankDaoImpl extends GenericDaoImpl<Bank> implements BankDao<Bank> {

    public BankDaoImpl(){
        super(Bank.class);
    }


}
