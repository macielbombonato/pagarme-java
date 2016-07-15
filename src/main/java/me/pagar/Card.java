package me.pagar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import me.pagar.util.JsonUtils;
import org.joda.time.DateTime;

public class Card extends PagarMeModel<String> {

    @Expose(deserialize = false)
    @SerializedName("card_hash")
    private String hash;

    @Expose(serialize = false)
    private Brand brand;

    @Expose(serialize = false)
    private String holderName;

    @Expose(deserialize = false)
    @SerializedName("card_number")
    private String number;

    @Expose(serialize = false)
    private String firstDigits;

    @Expose(serialize = false)
    private String lastDigits;

    @Expose(serialize = false)
    private String fingerprint;

    @Expose(serialize = false)
    private String country;

    @Expose(deserialize = false)
    private Integer customerId;

    @Expose(serialize = false)
    private Boolean valid;

    @Expose
    @SerializedName("expiration_date")
    private String expirationDate;

    @Expose(serialize = false)
    @SerializedName("date_updated")
    private DateTime updatedAt;

    @Expose(serialize = false)
    private Customer customer;

    public Brand getBrand() {
        return brand;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getFirstDigits() {
        return firstDigits;
    }

    public String getLastDigits() {
        return lastDigits;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCountry() {
        return country;
    }

    public Boolean getValid() {
        return valid;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setHash(String hash) {
        this.hash = hash;
        addUnsavedProperty("hash");
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
        addUnsavedProperty("holderName");
    }

    public void setNumber(String number) {
        this.number = number;
        addUnsavedProperty("number");
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
        addUnsavedProperty("customerId");
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        addUnsavedProperty("expirationDate");
    }

    public Card save() throws PagarMeException {
        final Card saved = super.save(getClass());
        copy(saved);

        return saved;
    }

    public Card refresh() throws PagarMeException {
        final Card other = JsonUtils.getAsObject(refreshModel(), Card.class);
        copy(other);
        flush();
        return other;
    }

    private void copy(Card other) {
        setId(other.getId());
        this.brand = other.brand;
        this.holderName = other.holderName;
        this.firstDigits = other.firstDigits;
        this.lastDigits = other.lastDigits;
        this.fingerprint = other.fingerprint;
        this.country = other.country;
        this.valid = other.valid;
    }

    public enum Brand {

        @SerializedName("amex")
        AMEX,

        @SerializedName("aura")
        AURA,

        @SerializedName("discover")
        DISCOVER,

        @SerializedName("elo")
        ELO,

        @SerializedName("hipercard")
        HIPERCARD,

        @SerializedName("jcb")
        JCB,

        @SerializedName("visa")
        VISA,

        @SerializedName("mastercard")
        MASTERCARD

    }

}
