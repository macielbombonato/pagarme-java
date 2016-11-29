package me.pagar;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import me.pagar.util.JsonUtils;
import org.joda.time.DateTime;

import javax.ws.rs.HttpMethod;

public class Transfer extends PagarMeModel<String> {

    @Expose
    @SerializedName("transaction_id")
    private Integer transactionId;

    @Expose
    private Integer amount;

    @Expose
    private Integer fee;

    @Expose
    private Type type;

    @Expose
    private Status status;

    @Expose(serialize = false)
    @SerializedName("funding_estimated_date")
    private DateTime fundingEstimatedDate;

    @Expose(serialize = false)
    @SerializedName("funding_date")
    private DateTime fundingDate;

    @Expose(serialize = false)
    @SerializedName("bank_account")
    private BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DateTime getFundingEstimatedDate() {
        return fundingEstimatedDate;
    }

    public void setFundingEstimatedDate(DateTime fundingEstimatedDate) {
        this.fundingEstimatedDate = fundingEstimatedDate;
    }

    public DateTime getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(DateTime fundingDate) {
        this.fundingDate = fundingDate;
    }

    public Transfer(Integer amount, BankAccount bankAccount) {
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    public Transfer create() throws PagarMeException {
        final PagarMeRequest request = new PagarMeRequest(
                HttpMethod.POST,
                String.format(
                        "/%s",
                        getClassName()
                )
        );

        request.setParameters(JsonUtils.objectToMap(this));

        return JsonUtils.getAsObject((JsonObject) request.execute(), Transfer.class);
    }

    /**
     * Tipo de transferencia realizada.
     */
    public enum Type {

        @SerializedName("ted")
        TED,

        @SerializedName("DOC")
        DOC,

        @SerializedName("credito_em_conta")
        CREDITO_EM_CONTA
    }

    /**
     * Status da transferência
     */
    public enum Status {

        @SerializedName("pending_transfer")
        PENDING_TRANSFER,

        @SerializedName("transferred")
        TRANSFERRED,

        @SerializedName("failed")
        FAILED,

        @SerializedName("processing")
        PROCESSING,

        @SerializedName("canceled")
        CANCELED

    }

}
