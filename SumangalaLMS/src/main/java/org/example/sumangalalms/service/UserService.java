package org.example.sumangalalms.service;

import org.example.sumangalalms.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
}
