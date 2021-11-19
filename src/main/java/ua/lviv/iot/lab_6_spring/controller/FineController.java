package ua.lviv.iot.lab_6_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_6_spring.DTO.FineDTO;
import ua.lviv.iot.lab_6_spring.DTO.LocationDTO;
import ua.lviv.iot.lab_6_spring.domain.Fine;
import ua.lviv.iot.lab_6_spring.domain.Location;
import ua.lviv.iot.lab_6_spring.service.FineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/fine")
public class FineController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FineController.class);

    @Autowired
    FineService fineService;

    @GetMapping
    public ResponseEntity<List<FineDTO>> getAllFine() {
        LOGGER.info("Successful");
        List<Fine> fineList = fineService.getAllFine();
        List<FineDTO> fineDTOS = new ArrayList<>();
        for (Fine fine:fineList) {
            FineDTO fineDTO = new FineDTO(fine);
            fineDTOS.add(fineDTO);
        }
        return new ResponseEntity<List<FineDTO>>(fineDTOS, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Fine> createFine(@Valid @RequestBody Fine fine) {
        LOGGER.info("Success added Fine");
        return new ResponseEntity<Fine>(fineService.createFine(fine), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FineDTO> updateFine (@PathVariable("id")final int id, @Valid @RequestBody final Fine fine) {
        if (fineService.getFineId(id) == null) {
            LOGGER.info("Id no taken");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        else {
        LOGGER.info("Updated an fine with id: " + id);
        fine.setId(id);
        fineService.updateFine(fine);
        return new ResponseEntity<FineDTO>(new FineDTO(fine), HttpStatus.OK);}
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Fine> deleteFine(@PathVariable("id") Integer id) {
        if (fineService.getFineId(id) == null) {
            LOGGER.info("Can't delete Fine ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }
        else {
        LOGGER.info("Successfully deleted Fine with id: " +id);
        fineService.deleteFine(id);
        return ResponseEntity.noContent().build();}

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FineDTO> getOne(@PathVariable("id") Integer id) {
        if (fineService.getFineId(id) == null) {
            LOGGER.info("Can't get Fine ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            LOGGER.info("Successfully get location with id: " + id);
            Fine fine = fineService.getOne(id);

            FineDTO fineDTO = new FineDTO(fine);
            return new ResponseEntity<FineDTO>(fineDTO, HttpStatus.OK);
        }
    }

}
