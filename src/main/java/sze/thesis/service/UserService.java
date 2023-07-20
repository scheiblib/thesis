package sze.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sze.thesis.persistence.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
