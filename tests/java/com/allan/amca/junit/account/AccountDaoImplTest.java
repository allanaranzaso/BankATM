package com.allan.amca.junit.account;

import com.allan.amca.account.AccountDaoImpl;
import com.allan.amca.data.Dao;
import com.allan.amca.data.DaoFactory;
import com.allan.amca.enums.DaoType;
import com.allan.amca.junit.data.DaoAbstractTest;
import com.allan.amca.transaction.Transaction;
import com.allan.amca.user.Client;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

class AccountDaoImplTest extends DaoAbstractTest {

    @Test
    void readRecord() {
        Dao daoImpl = DaoFactory.createDao(DaoType.ACCOUNT);

        retrieve(daoImpl, 4500123410000000L, BigDecimal.valueOf(2000.0));
        retrieve(daoImpl, 4500123410000001L, BigDecimal.valueOf(0.0));
        retrieve(daoImpl, 4500123410000002L, BigDecimal.valueOf(0.0));
    }

    @Test
    void badRead() {
        Dao<Client, Long> daoImpl = DaoFactory.createDao(DaoType.ACCOUNT);

        badRead(() -> daoImpl.retrieve(null), IllegalArgumentException.class, "Argument cannot be null");
    }

    @Test
    void listTransaction() {
        AccountDaoImpl dao = new AccountDaoImpl<Long, Transaction>();

        dao.recordsRetrieved(4500123410000000L);
    }

//    @Test
    // test should add an entry to the clients and then the accounts dbs
    void addRecord() throws SQLException {
        Dao daoImpl                     = DaoFactory.createDao(DaoType.ACCOUNT);
        Dao<Client, Long> retrieveUser  = DaoFactory.createDao(DaoType.USER);
        Client clientToAdd              = retrieveUser.retrieve(4519011123012445L);

        if (clientToAdd != null) {
            /**
             * if user exists during the test, delete the account and proceed to adding it
             * this is so that you don't run into any false positives while running the unit tests
             */
            // failing foreign key constraint on the clients and transactions tables because deleting client ID
//            daoImpl.delete(clientToAdd);
        }
        create(daoImpl, clientToAdd, true);
    }


    @Test
    void executeUpdate() {
        Dao daoImpl                     = DaoFactory.createDao(DaoType.ACCOUNT);
        Dao<Client, Long> retrieveUser  = DaoFactory.createDao(DaoType.USER);
        Client clientToUpdate           = retrieveUser.retrieve(4500123410000000L);

        update(daoImpl, 2000L , clientToUpdate, true);
    }
}