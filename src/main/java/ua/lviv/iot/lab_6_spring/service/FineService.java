package ua.lviv.iot.lab_6_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.lab_6_spring.domain.Fine;
import ua.lviv.iot.lab_6_spring.domain.User;
import ua.lviv.iot.lab_6_spring.repository.FineRepository;

import java.util.List;

@Service
public class FineService {

    @Autowired
    FineRepository fineRepository;


    public List<Fine> getAllFine() {
        return fineRepository.findAll();
    }

    public Fine getOne(Integer id) {
        return fineRepository.getOne(id);
    }

    @Transactional
    public Fine createFine(Fine fine) {
        return fineRepository.save(fine);
    }

    @Transactional
    public void updateFine(Fine fine) {
        fineRepository.save(fine);

    }

    public Fine getFineId(final Integer id) {
        return fineRepository.findById(id).orElse(null);
    }


    @Transactional
    public void deleteFine(Integer id) {

        fineRepository.deleteById(id);

    }

}
