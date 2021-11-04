package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String identity_document;
    private String driver_license;
    private String mail;
    private String phone_number;
    private String payment_card;
    private String security_login;


    public User(Integer id, String first_name, String last_name,
                String identity_document, String driver_license,
                String mail, String phone_number,
                String payment_card, String security_login) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.identity_document = identity_document;
        this.driver_license = driver_license;
        this.mail = mail;
        this.phone_number = phone_number;
        this.payment_card = payment_card;
        this.security_login = security_login;
    }

    public User(String first_name, String last_name, String identity_document,
                String driver_license, String mail,
                String phone_number, String payment_card, String security_login) {
        this(null, first_name, last_name, identity_document,
                driver_license, mail, phone_number, payment_card, security_login);
    }
    @Override
    public String toString() {
        return String.format("\n| %3d | %-15s | %-15s | %-10s "
                        + "| %-10s | %-20s | %-6s | %-6s | %-15s |",
                id, first_name, last_name, identity_document,
                driver_license, mail, phone_number, payment_card,
                security_login);
    }

}

