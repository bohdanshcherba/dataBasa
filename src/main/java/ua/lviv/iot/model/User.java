package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String identityDocument;
    private String driverLicense;
    private String mail;
    private String phoneNumber;
    private String paymentCard;
    private String securityLogin;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "identity_document")
    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    @Basic
    @Column(name = "driver_license")
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "payment_card")
    public String getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(String paymentCard) {
        this.paymentCard = paymentCard;
    }

    @Basic
    @Column(name = "security_login")
    public String getSecurityLogin() {
        return securityLogin;
    }

    public void setSecurityLogin(String securityLogin) {
        this.securityLogin = securityLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(identityDocument, user.identityDocument) &&
                Objects.equals(driverLicense, user.driverLicense) &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(paymentCard, user.paymentCard) &&
                Objects.equals(securityLogin, user.securityLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, identityDocument, driverLicense, mail, phoneNumber, paymentCard, securityLogin);
    }

    public User() {
    }


    public User(String firstName, String lastName, String identityDocument, String driverLicense, String mail, String phoneNumber, String paymentCard, String securityLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
        this.driverLicense = driverLicense;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.paymentCard = paymentCard;
        this.securityLogin = securityLogin;
    }


    @Override
    public String toString() {
        return String.format("\n| %3d | %-15s | %-15s | %-10s "
                        + "| %-10s | %-20s | %-6s | %-6s | %-15s |",
                id, firstName, lastName, identityDocument,
                driverLicense, mail, phoneNumber, paymentCard,
                securityLogin);
    }

}


