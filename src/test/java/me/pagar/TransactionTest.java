package me.pagar;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class TransactionTest extends BaseTest {

    private Transaction transaction;

    @Before
    public void setUp() {
        super.setUp();
        transaction = new Transaction();
    }

    @Test
    public void testFindAll() throws Throwable {
        final Collection<Transaction> transactions = transaction.list(5, 1);
        Assert.assertNotEquals(0, transactions.size());
    }

    @Test
    public void testCardHashKey() throws Throwable {
        final CardHashKey cardHashKey = transaction.cardHashKey();
        Assert.assertNotNull(cardHashKey);
    }

}
