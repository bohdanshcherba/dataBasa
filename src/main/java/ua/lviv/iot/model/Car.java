package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`car`", schema = "shcherba")
public class Car {
    private Integer id;
    private String name;
    private String carBodyStyle;
    private Float priceForDay;
    private Integer seats;
    private Integer doors;
    private String gearboxType;
    private Integer accessible;
    private Integer locationId;

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
    @Column(name = "`name`")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "`car_body_style`")
    public String getCarBodyStyle() {
        return carBodyStyle;
    }

    public void setCarBodyStyle(String carBodyStyle) {
        this.carBodyStyle = carBodyStyle;
    }

    @Basic
    @Column(name = "`price_for_day`")
    public Float getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(Float priceForDay) {
        this.priceForDay = priceForDay;
    }

    @Basic
    @Column(name = "`seats`")
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Basic
    @Column(name = "`doors`")
    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    @Basic
    @Column(name = "`gearbox_type`")
    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    @Basic
    @Column(name = "`accessible`")
    public Integer getAccessible() {
        return accessible;
    }

    public void setAccessible(Integer accessible) {
        this.accessible = accessible;
    }

    @Basic
    @Column(name = "`location_id`")
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(name, car.name) &&
                Objects.equals(carBodyStyle, car.carBodyStyle) &&
                Objects.equals(priceForDay, car.priceForDay) &&
                Objects.equals(seats, car.seats) &&
                Objects.equals(doors, car.doors) &&
                Objects.equals(gearboxType, car.gearboxType) &&
                Objects.equals(accessible, car.accessible) &&
                Objects.equals(locationId, car.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, carBodyStyle, priceForDay, seats, doors, gearboxType, accessible, locationId);
    }

    public Car() {

    }

    public Car(String name, String carBodyStyle, Float priceForDay, Integer seats, Integer doors, String gearboxType, Integer accessible, Integer locationId) {
        this.name = name;
        this.carBodyStyle = carBodyStyle;
        this.priceForDay = priceForDay;
        this.seats = seats;
        this.doors = doors;
        this.gearboxType = gearboxType;
        this.accessible = accessible;
        this.locationId = locationId;
    }


    @Override
    public String toString() {
        return String.format("| %3d | %-30s | %-20s | %-15s "
                        + "| %-5s | %-8s | %-15s | %-10s | %-10s |\n",
                id, name, carBodyStyle, priceForDay,
                seats, doors, gearboxType, accessible, locationId);
    }
}
