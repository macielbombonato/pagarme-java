package me.pagar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Collection;

public class Customer extends PagarMeModel<Integer> {

    @Expose
    private String documentNumber;

    @Expose(serialize = false)
    private String documentType;

    @Expose
    private String name;

    @Expose
    private String email;

    @Expose
    private String gender;

    @Expose
    @SerializedName("born_at")
    private LocalDate bornAt;

    @Expose(deserialize = false)
    private Address address;

    @Expose(deserialize = false)
    private Phone phone;

    @Expose(serialize = false)
    private Collection<Address> addresses;

    @Expose(serialize = false)
    private Collection<Phone> phones;

    public Customer() {
        super();
    }

    public Customer(final String name, final String email) {
        this();
        this.name = name;
        this.email = email;
        this.addresses = new ArrayList<Address>();
        this.phones = new ArrayList<Phone>();
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBornAt() {
        return bornAt;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = documentNumber;
        addUnsavedProperty("documentNumber");
    }

    public void setDocumentType(final String documentType) {
        this.documentType = documentType;
        addUnsavedProperty("documentType");
    }

    public void setName(final String name) {
        this.name = name;
        addUnsavedProperty("name");
    }

    public void setEmail(final String email) {
        this.email = email;
        addUnsavedProperty("email");
    }

    public void setGender(final String gender) {
        this.gender = gender;
        addUnsavedProperty("gender");
    }

    public void setBornAt(final LocalDate bornAt) {
        this.bornAt = bornAt;
        addUnsavedProperty("bornAt");
    }

    public void setAddress(Address address) {
        this.address = address;
        addUnsavedProperty("address");
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
        addUnsavedProperty("phone");
    }

    @Override
    public void setId(Integer id) {
        throw new UnsupportedOperationException("Not allowed.");
    }

    @Override
    public void setClassName(String className) {
        throw new UnsupportedOperationException("Not allowed.");
    }

}
