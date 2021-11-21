package ua.lviv.iot.lab_6_spring.DTO;


import ua.lviv.iot.lab_6_spring.domain.User;

public class UserDTO {

    private User user;

    public UserDTO(User user) {
        this.user = user;
    }

    public Integer getId() {
        return user.getId();
    }

    public String getFirst_name() {
        return user.getFirst_name();
    }

    public String getLast_name() {
        return user.getLast_name();
    }

    public String getIdentity_document() {
        return user.getIdentity_document();
    }

    public String getDriver_license() {
        return user.getDriver_license();
    }

    public String getMail() {
        return user.getMail();
    }

    public String getPhone_number() {
        return user.getPhone_number();
    }

    public String getPayment_card() {
        return user.getPayment_card();
    }

    public String getSecurity_login() {
        return user.getSecurity_login();
    }
}
