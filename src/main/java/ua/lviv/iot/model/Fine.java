package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Fine {
    private Integer id;
    private String type_of_fine;
    private String date;
    private Integer user_id;

    public Fine(Integer id, String type_of_fine, String date, Integer user_id) {
        this.id = id;
        this.type_of_fine = type_of_fine;
        this.date = date;
        this.user_id = user_id;
    }

    public Fine(String type_of_fine, String date, Integer user_id) {
        this(null, type_of_fine, date, user_id);
    }

    @Override
    public String toString() {
        return String.format("\n| %3d | %-40s | %-20s | %s | ",
                id, type_of_fine, date, user_id);
    }
}
