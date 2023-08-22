package sze.thesis.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sze.thesis.model.CreateUserDto;
import sze.thesis.model.UserResponseDto;
import sze.thesis.persistence.entity.User;
import sze.thesis.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {

    private UserService userService;

    @GetMapping("/findUserById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findUserById(@PathVariable("id") long id) {
        return userService.findUserById(id);
    }
    @GetMapping("/findUserByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findUserByEmail(@PathVariable("email") String email) {
        return userService.findUserByEmail(email);
    }
    @GetMapping("/findAllUser")
    public List<User> findAll(){
        return userService.findAllUser();
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody CreateUserDto createUserDto) throws Exception {
        userService.registerUser(createUserDto);
    }
    @PutMapping("/update/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserPersonalData(@PathVariable("email") String email,
                                       @RequestBody CreateUserDto createUserDto) {
            userService.updateUserPersonalData(email, createUserDto);
    }
}
