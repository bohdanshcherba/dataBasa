package ua.lviv.iot.lab_6_spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "car_body_style")
    private String carBodyStyle;
    @Basic
    @Column(name = "price_for_day")
    private Float priceForDay;
    @Basic
    @Column(name = "seats")
    private Integer seats;
    @Basic
    @Column(name = "doors")
    private Integer doors;
    @Basic
    @Column(name = "gearbox_type")
    private String gearboxType;
    @Basic
    @Column(name = "access_car")
    private Integer accessCar;
    @Basic
    @Column(name = "date_take")
    private String dateTake;
    @Basic
    @Column(name = "to_pay")
    private Float toPay;
    @Basic
    @Column(name = "location_id")
    private Integer locationId;

    public Car(Integer id,
               String name,
               String carBodyStyle,
               Float priceForDay,
               Integer seats,
               Integer doors,
               String gearboxType,
               Integer accessCar,
               String dateTake,
               Float toPay,
               Integer locationId
    ) {
        this.id = id;
        this.name = name;
        this.carBodyStyle = carBodyStyle;
        this.priceForDay = priceForDay;
        this.seats = seats;
        this.doors = doors;
        this.gearboxType = gearboxType;
        this.accessCar = accessCar;

        this.dateTake = dateTake;
        this.toPay = toPay;
        this.locationId = locationId;

    }
//
//    public Car(
//            String name,
//            String car_body_style,
//            Float price_for_day,
//            Integer seats,
//            Integer doors,
//            String gearbox_type,
//            Boolean accessible,
//            String date_take,
//            Float to_pay,
//            Integer location_id) {
//        this(null, name, car_body_style, price_for_day,
//                seats, doors, gearbox_type, accessible, date_take, to_pay,
//                location_id);
//    }


}
