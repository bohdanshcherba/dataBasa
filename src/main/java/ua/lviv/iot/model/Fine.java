package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Fine {
    private Integer id;
    private String typeOfFine;
    private String date;
    private Integer userId;

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
    @Column(name = "type_of_fine")
    public String getTypeOfFine() {
        return typeOfFine;
    }

    public void setTypeOfFine(String typeOfFine) {
        this.typeOfFine = typeOfFine;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fine fine = (Fine) o;
        return Objects.equals(id, fine.id) &&
                Objects.equals(typeOfFine, fine.typeOfFine) &&
                Objects.equals(date, fine.date) &&
                Objects.equals(userId, fine.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfFine, date, userId);
    }

    public Fine() {
    }


    public Fine(String typeOfFine, String date, Integer userId) {
        this.typeOfFine = typeOfFine;
        this.date = date;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("\n| %3d | %-40s | %-20s | %s | ",
                id, typeOfFine, date, userId);
    }
}


