package ua.lviv.iot.lab_6_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.lab_6_spring.domain.Location;
import ua.lviv.iot.lab_6_spring.domain.User;
import ua.lviv.iot.lab_6_spring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);

    }

    public User getUserId(final Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteUser(Integer id) {

        userRepository.deleteById(id);

    }
}
