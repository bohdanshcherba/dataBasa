package ua.lviv.iot.lab_6_spring.DTO;


import ua.lviv.iot.lab_6_spring.domain.Location;

public class LocationDTO {
    private Location location;

    public LocationDTO(Location location) {
        this.location = location;
    }

    public Integer getId() {
        return location.getId();
    }

    public String getName() {
        return location.getName();
    }

    public String getCountry() {
        return location.getCountry();
    }

    public String getCity() {
        return location.getCity();
    }

    public String getStreet() {
        return location.getStreet();
    }

    public String getNumber() {
        return location.getNumber();
    }

    public String getZip_code() {
        return location.getZip_code();
    }

    public Integer getNumber_available_cars() {
        return location.getNumber_available_cars();
    }


}
