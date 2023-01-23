package com.tweteroo.api.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.Models.UserModels;
import com.tweteroo.api.Repository.UserRepository;
import com.tweteroo.api.dto.UserDTO;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDTO user) {

        Optional<UserModels> userExist = userRepository.findUserByUsername(user.username());

        if (!userExist.isPresent()) {
            userRepository.save(new UserModels(user));
        }
    }
}
