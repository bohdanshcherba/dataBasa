package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Location {
    private Integer id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zipCode;
    private Integer numberAvailableCars;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "number_available_cars")
    public Integer getNumberAvailableCars() {
        return numberAvailableCars;
    }

    public void setNumberAvailableCars(Integer numberAvailableCars) {
        this.numberAvailableCars = numberAvailableCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(name, location.name) &&
                Objects.equals(country, location.country) &&
                Objects.equals(city, location.city) &&
                Objects.equals(street, location.street) &&
                Objects.equals(number, location.number) &&
                Objects.equals(zipCode, location.zipCode) &&
                Objects.equals(numberAvailableCars, location.numberAvailableCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, city, street, number, zipCode, numberAvailableCars);
    }

    public Location() {
    }

    public Location(String name, String country, String city, String street, String number, String zipCode, Integer numberAvailableCars) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.numberAvailableCars = numberAvailableCars;
    }

    @Override
    public String toString() {
        return String.format("\n| %3d | %-30s | %-20s "
                        + "| %-15s | %-15s | %-4s | %-6s | %s |",
                id, name, country, city, street,
                number, zipCode, numberAvailableCars);
    }

}
