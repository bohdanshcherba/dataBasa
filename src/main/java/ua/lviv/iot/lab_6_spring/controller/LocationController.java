package ua.lviv.iot.lab_6_spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_6_spring.DTO.LocationDTO;
import ua.lviv.iot.lab_6_spring.DTO.UserDTO;
import ua.lviv.iot.lab_6_spring.domain.Location;

import ua.lviv.iot.lab_6_spring.domain.User;
import ua.lviv.iot.lab_6_spring.service.LocationService;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocation() {
        LOGGER.info("Successful");
        List<Location> locationList = locationService.getAllLocation();
        List<LocationDTO> locationDTOS = new ArrayList<>();
        for (Location location : locationList) {
            LocationDTO locationDTO = new LocationDTO(location);
            locationDTOS.add(locationDTO);
        }
        return new ResponseEntity<List<LocationDTO>>(locationDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@Valid @RequestBody Location location) {
        LOGGER.info("Success added Location");
        return new ResponseEntity<Location>(locationService.createLocation(location), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable("id") final int id, @Valid @RequestBody final Location location) {
        if (locationService.getLocationId(id) == null) {
            LOGGER.info("Id no taken");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        else{
        LOGGER.info("Updated an Location with id: " + id);
        location.setId(id);
        locationService.updateLocation(location);
        return new ResponseEntity<LocationDTO>(new LocationDTO(location), HttpStatus.OK);}
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable("id") Integer id) {
        if (locationService.getLocationId(id) == null) {
            LOGGER.info("Can't delete Location ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        else {
        LOGGER.info("Successfully deleted Location with id: " + id);
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }}
    @GetMapping(path = "/{id}")
    public ResponseEntity<LocationDTO> getOne(@PathVariable("id") Integer id) {
        if (locationService.getLocationId(id) == null) {
            LOGGER.info("Can't get location ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            LOGGER.info("Successfully get location with id: " + id);
            Location location = locationService.getOne(id);

            LocationDTO locationDTO = new LocationDTO(location);
            return new ResponseEntity<LocationDTO>(locationDTO, HttpStatus.OK);
        }
    }

}
