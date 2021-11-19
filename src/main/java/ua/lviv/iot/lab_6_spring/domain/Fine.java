package ua.lviv.iot.lab_6_spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "type_of_fine")
    private String type_of_fine;
    @Column(name = "date")
    private String date;
    @Column(name = "user_id")
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