package ua.lviv.iot.lab_6_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.lab_6_spring.domain.Location;
import ua.lviv.iot.lab_6_spring.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;


    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    @Transactional
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Transactional
    public void updateLocation(Location location) {
        locationRepository.save(location);

    }

    public Location getLocationId(final Integer id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteLocation(Integer id) {

        locationRepository.deleteById(id);

    }
}
