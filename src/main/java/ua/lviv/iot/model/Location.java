package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private Integer id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zip_code;
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

    @Override
    public String toString() {
        return String.format("\n| %3d | %-30s | %-20s "
                        + "| %-15s | %-15s | %-4s | %-6s | %s |",
                id, name, country, city, street,
                number, zip_code, number_available_cars);
    }

}
