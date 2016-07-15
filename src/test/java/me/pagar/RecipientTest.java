package me.pagar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class RecipientTest extends BaseTest {

    private static final String RECIPIENT_ID_1 = "re_cipdzcai60014tm6ek5ohwvw9";
    private static final String RECIPIENT_ID_2 = "re_cipoamvam0041xx6dp4qif672";

    private Recipient recipient;

//    @Before
//    public void setUp() {
//        super.setUp();
//        recipient = new Recipient();
//        recipient.setId(RECIPIENT_ID_1);
//    }
//
//    @Test
//    public void testFindAll() throws Throwable {
//        final Collection<Recipient> recipients = recipient.find(5, 1);
//        Assert.assertNotEquals(0, recipients.size());
//    }
//
//    @Test
//    public void testRefresh() throws Throwable {
//        recipient.refresh();
//        Assert.assertNotNull(recipient.getBankAccount());
//
//        Assert.assertEquals(15107278, recipient.getBankAccount().getId().longValue());
//    }
//
//    @Test
//    public void testSave() throws Throwable {
//        recipient.setId(RECIPIENT_ID_2);
//        recipient.refresh();
//
//        recipient.setTransferDay(1);
//        recipient.setTransferEnabled(false);
//        recipient.setTransferInterval(Recipient.TransferInterval.WEEKLY);
//
//        final BankAccount bankAccount = recipient.getBankAccount();
//        bankAccount.setBankCode("033");
//        bankAccount.setAgencia("0001");
//        bankAccount.setConta("13006756");
//        bankAccount.setContaDv("8");
//
//        recipient.save();
//
//        Assert.assertEquals("033", recipient.getBankAccount().getBankCode());
//    }
//
//    @Test
//    public void testCreateBulkAnticipation() throws Throwable {
//        BulkAnticipation anticipation = new BulkAnticipation(DateTime.now(DateTimeZone.UTC).plusDays(10),
//                BulkAnticipation.Timeframe.START, 561599, true); //valor em centavos
//
//        anticipation = recipient.bulkAnticipations(anticipation);
//        Assert.assertNotNull(anticipation.getId());
//    }
//
//    @Test
//    public void testCreateBulkAnticipationLimits() throws Throwable {
//        final BulkAnticipation.Limits limits = recipient.bulkAnticipationsLimits();
//        Assert.assertNotNull(limits);
//    }
//
//    @Test
//    public void testFindAllBulkAnticipations() throws Throwable {
//        final Collection<BulkAnticipation> anticipations = recipient.bulkAnticipations();
//        Assert.assertEquals(0, anticipations.size());
//    }

}
