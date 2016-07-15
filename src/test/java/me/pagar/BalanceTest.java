package me.pagar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BalanceTest extends BaseTest {

    private Balance recipient;

    @Before
    public void setUp() {
        super.setUp();
        recipient = new Balance();
    }

    @Test
    public void testRefresh() throws Throwable {
        recipient.refresh();
        Assert.assertNotNull(recipient.getAvailable());
    }


}
