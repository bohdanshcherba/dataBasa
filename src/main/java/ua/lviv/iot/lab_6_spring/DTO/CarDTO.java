package ua.lviv.iot.lab_6_spring.DTO;

import ua.lviv.iot.lab_6_spring.domain.Car;


public class CarDTO {
    private Car car;

    public CarDTO(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return car.getId();
    }

    public String getName() {
        return car.getName();
    }

    public String getCarBodyStyle() {
        return car.getCarBodyStyle();
    }

    public Float getPriceForDay() {
        return car.getPriceForDay();
    }

    public Integer getSeats() {
        return car.getSeats();
    }

    public Integer getDoors() {
        return car.getDoors();
    }

    public String getGearboxType() {
        return car.getGearboxType();
    }

    public Integer getAccessible() {
        return car.getAccessCar();
    }


    public String getDateTake() {
        return car.getDateTake();
    }

    public Float getToPay() {
        return car.getToPay();
    }

    public Integer getLocationId() {
        return car.getLocationId();
    }

}
