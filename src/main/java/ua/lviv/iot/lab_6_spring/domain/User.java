package ua.lviv.iot.lab_6_spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "identity_document")
    private String identity_document;

    @Column(name = "driver_license")
    private String driver_license;
    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "payment_card")
    private String payment_card;

    @Column(name = "security_login")
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


}
