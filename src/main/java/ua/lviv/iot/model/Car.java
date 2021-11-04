package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private Integer id;
    private String name;
    private String car_body_style;
    private Float price_for_day;
    private Integer seats;
    private Integer doors;
    private String gearbox_type;
    private Boolean accessible;
    private String date_take;
    private Float to_pay;
    private Integer location;


    public Car(Integer id,
               String name,
               String car_body_style,
               Float price_for_day,
               Integer seats,
               Integer doors,
               String gearbox_type,
               Boolean accessible,
               Integer location) {
        this.id = id;
        this.name = name;
        this.car_body_style = car_body_style;
        this.price_for_day = price_for_day;
        this.seats = seats;
        this.doors = doors;
        this.gearbox_type = gearbox_type;
        this.accessible = accessible;
        this.location = location;
    }

    public Car(String name, String car_body_style, Float price_for_day,
               Integer seats, Integer doors,
               String gearbox_type, Boolean accessible,
               Integer location_id) {
        this(null, name, car_body_style, price_for_day,
                seats, doors, gearbox_type, accessible,
                location_id);
    }


    @Override
    public String toString() {
        return String.format("| %3d | %-30s | %-20s | %-15s "
                + "| %-5s | %-8s | %-15s | %-10s | %-10s |\n",
                id, name, car_body_style, price_for_day,
                seats, doors, gearbox_type, accessible, location);
    }

}
