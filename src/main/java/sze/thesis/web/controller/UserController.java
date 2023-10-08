package sze.thesis.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sze.thesis.model.CreateUserDto;
import sze.thesis.model.UserResponseDto;
import sze.thesis.persistence.entity.User;
import sze.thesis.service.KeyCloakService;
import sze.thesis.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {

    private UserService userService;
    private KeyCloakService service;

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@Valid @RequestBody CreateUserDto createUserDto) throws Exception {
        service.addUser(createUserDto);
        return "User added successfully!";
    }

    @GetMapping("/findByUsername/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserRepresentation> getUser(@PathVariable("userName") String userName){
        List<UserRepresentation> user = service.getUser(userName);
        return user;
    }

    @PutMapping(path = "/update/{userId}")
    public String updateUser(@PathVariable("userId") String userId,   @RequestBody CreateUserDto userDTO){
        service.updateUser(userId, userDTO);
        return "User Details Updated Successfully.";
    }

    @DeleteMapping(path = "/delete/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        service.deleteUser(userId);
        return "User Deleted Successfully.";
    }

    @GetMapping(path = "/verification-link/{userId}")
    public String sendVerificationLink(@PathVariable("userId") String userId){
        service.sendVerificationLink(userId);
        return "Verification Link Send to Registered E-mail Id.";
    }

    @GetMapping(path = "/reset-password/{userId}")
    public String sendResetPassword(@PathVariable("userId") String userId){
        service.sendResetPassword(userId);
        return "Reset Password Link Send Successfully to Registered E-mail Id.";
    }
//    }
//    @GetMapping("/findUserByEmail/{email}")
//    @ResponseStatus(HttpStatus.OK)
//    public UserResponseDto findUserByEmail(@PathVariable("email") String email) {
//        return userService.findUserByEmail(email);
//    }
//    @GetMapping("/findAllUser")
//    public List<User> findAll(){
//        return userService.findAllUser();
//    }
//
//    @PostMapping(path = "/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void registerUser(@Valid @RequestBody CreateUserDto createUserDto) throws Exception {
//        userService.registerUser(createUserDto);
//    }
//    @PutMapping("/update/{email}")
//    @ResponseStatus(HttpStatus.OK)
//    public void updateUserPersonalData(@PathVariable("email") String email,
//                                       @RequestBody CreateUserDto createUserDto) {
//            userService.updateUserPersonalData(email, createUserDto);
//    }
}
