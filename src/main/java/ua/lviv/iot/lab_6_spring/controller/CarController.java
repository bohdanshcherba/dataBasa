package ua.lviv.iot.lab_6_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_6_spring.DTO.CarDTO;
import ua.lviv.iot.lab_6_spring.domain.Car;
import ua.lviv.iot.lab_6_spring.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCar() {
        LOGGER.info("Successful");
        List<Car> carList = carService.getAllCar();
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : carList) {
            CarDTO carDTO = new CarDTO(car);
            carDTOS.add(carDTO);
        }
        return new ResponseEntity<List<CarDTO>>(carDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        LOGGER.info("Success added car");
        return new ResponseEntity<Car>(carService.createCar(car), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDTO> updateCar(@PathVariable("id") final int id, @Valid @RequestBody final Car car) {
        if (carService.getCarId(id) == null) {
            LOGGER.info("Id no taken");
        }
        LOGGER.info("Updated an car with id: " + id);
        car.setId(id);
        carService.updateCar(car);
        return new ResponseEntity<CarDTO>(new CarDTO(car), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id) {
        if (carService.getCarId(id) == null) {
            LOGGER.info("Can't delete car ");

        }
        LOGGER.info("Successfully deleted car with id: " + id);
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
