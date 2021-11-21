package ua.lviv.iot.lab_6_spring.DTO;

import ua.lviv.iot.lab_6_spring.domain.Fine;

public class FineDTO {
    private Fine fine;

    public FineDTO(Fine fine) {
        this.fine = fine;
    }

    public Integer getId() {
        return fine.getId();
    }

    public String getTypeOfFine() {
        return fine.getType_of_fine();
    }

    public String getData() {
        return fine.getDate();
    }

    public Integer getUserId() {
        return fine.getUser_id();
    }
}
