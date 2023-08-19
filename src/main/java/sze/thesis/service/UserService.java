package sze.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sze.thesis.model.CreateUserDto;
import sze.thesis.model.UserResponseDto;
import sze.thesis.persistence.entity.User;
import sze.thesis.persistence.repository.UserRepository;
import sze.thesis.service.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDto findUserById(long id){
        User maybeUser = userRepository.findById(id);
        return userMapper.mapUserEntityToUserResponseDto(maybeUser);
    }

    public UserResponseDto findUserByEmail(String email){
        User maybeUser = userRepository.findByEmail(email);
        return userMapper.mapUserEntityToUserResponseDto(maybeUser);
    }

    public User registerUser(CreateUserDto createUserDto) throws Exception {
        String email = createUserDto.getEmail();
        if(userRepository.findByEmail(email) != null){
            throw new Exception("Email address already in use.");
        }
        User user = userMapper.mapForUserRegister(createUserDto);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
    private User updateUserPersonalData(User current, CreateUserDto createUserdto) {
        current.setFirstName(createUserdto.getFirstName());
        current.setLastName(createUserdto.getLastName());
        current.setEmail(createUserdto.getEmail());
        current.setPhone(createUserdto.getPhone());
        current.setCity(createUserdto.getCity());
        current.setAddress(createUserdto.getAddress());
        return current;
    }

}
