package ua.lviv.iot.lab_6_spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.lab_6_spring.domain.Car;

import ua.lviv.iot.lab_6_spring.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;


    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Transactional
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public void updateCar(Car car) {
        carRepository.save(car);

    }

    public Car getCarId(final Integer id) {
        return carRepository.findById(id).orElse(null);
    }


    @Transactional
    public void deleteCar(Integer id) {

        carRepository.deleteById(id);

    }

}
