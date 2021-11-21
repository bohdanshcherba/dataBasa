package ua.lviv.iot.lab_6_spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_6_spring.DTO.UserDTO;
import ua.lviv.iot.lab_6_spring.domain.User;
import ua.lviv.iot.lab_6_spring.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        LOGGER.info("Successful");
        List<User> userList = userService.getAllUser();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : userList) {
            UserDTO userDTO = new UserDTO(user);
            userDTOS.add(userDTO);
        }
        return new ResponseEntity<List<UserDTO>>(userDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        LOGGER.info("Success added user");
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") final int id, @Valid @RequestBody final User user) {
        if (userService.getUserId(id) == null) {
            LOGGER.info("Id no taken");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            LOGGER.info("Updated an user with id: " + id);
            user.setId(id);
            userService.updateUser(user);
            return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        if (userService.getUserId(id) == null) {
            LOGGER.info("Can't delete user ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            LOGGER.info("Successfully deleted user with id: " + id);
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserId(@PathVariable("id") Integer id) {
        if (userService.getUserId(id) == null) {
            LOGGER.info("Can't get user ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            LOGGER.info("Successfully get user with id: " + id);
            User user = userService.getOne(id);

            UserDTO userDTO = new UserDTO(user);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        }
    }
}
