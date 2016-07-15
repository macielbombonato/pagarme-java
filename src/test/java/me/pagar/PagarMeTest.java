package me.pagar;

import org.junit.Before;
import org.junit.Test;

public class PagarMeTest extends BaseTest {

    private String payload = "id=544940&fingerprint=bb351be69b92b8cb734148b92792dc08c5099590&event=transaction_status_changed&" +
            "old_status=processing&desired_status=paid&current_status=paid&object=transaction&transaction[object]=transaction&" +
            "transaction[status]=paid&transaction[refuse_reason]=null&transaction[status_reason]=acquirer&" +
            "transaction[acquirer_response_code]=0&transaction[acquirer_name]=pagarme&transaction[authorization_code]=282732&" +
            "transaction[soft_descriptor]=null&transaction[tid]=544940&transaction[nsu]=544940&" +
            "transaction[date_created]=2016-06-30T21:09:36.250Z&transaction[date_updated]=2016-06-30T21:09:36.902Z&" +
            "transaction[amount]=29000&transaction[authorized_amount]=29000&transaction[paid_amount]=29000&" +
            "transaction[refunded_amount]=0&transaction[installments]=1&transaction[id]=544940&transaction[cost]=50&" +
            "transaction[card_holder_name]=JOSE DA SILVA&transaction[card_last_digits]=6590&transaction[card_first_digits]=491665&" +
            "transaction[card_brand]=visa&transaction[postback_url]=http://requestb.in/1jhec181&transaction[payment_method]=credit_card&" +
            "transaction[capture_method]=ecommerce&transaction[antifraud_score]=null&transaction[boleto_url]=null&" +
            "transaction[boleto_barcode]=null&transaction[boleto_expiration_date]=null&transaction[referer]=api_key&" +
            "transaction[ip]=200.153.130.171&transaction[subscription_id]=null&transaction[phone]=null&transaction[address]=null&" +
            "transaction[customer]=null&transaction[card][object]=card&transaction[card][id]=card_ciq2rdvr700emxl6ezkuj78zk&" +
            "transaction[card][date_created]=2016-06-30T20:23:44.132Z&transaction[card][date_updated]=2016-06-30T20:23:44.457Z&" +
            "transaction[card][brand]=visa&transaction[card][holder_name]=JOSE DA SILVA&transaction[card][first_digits]=491665&" +
            "transaction[card][last_digits]=6590&transaction[card][country]=BZ&transaction[card][fingerprint]=F36BXZjIsvT7&" +
            "transaction[card][customer]=undefined&transaction[card][valid]=true&transaction[card][expiration_date]=222";

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testValidateRequestSignature() throws Throwable {
        PagarMe.validateRequestSignature(payload, "sha1=14d0986e5ed9cf106e021b7c472b604dd06e5108");
    }

}
