package com.WitsHelp.WitsHelp.Service;

import com.WitsHelp.WitsHelp.Entity.User;
import com.WitsHelp.WitsHelp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
//    Get user by ID
    public Optional<User> getUser(Long user_id) {
        return userRepository.findById(user_id);
    }
}
