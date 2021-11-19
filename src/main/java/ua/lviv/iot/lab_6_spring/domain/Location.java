package ua.lviv.iot.lab_6_spring.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "number_available_cars")
    private Integer number_available_cars;

    public Location(Integer id, String name, String country, String city,
                    String street, String number, String zip_code,
                    Integer number_available_cars) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zip_code = zip_code;
        this.number_available_cars = number_available_cars;
    }

    public Location(String name, String country, String city,
                    String street, String number,
                    String zip_code, Integer number_available_cars) {
        this(null, name, country, city, street, number, zip_code, number_available_cars);
    }




}

