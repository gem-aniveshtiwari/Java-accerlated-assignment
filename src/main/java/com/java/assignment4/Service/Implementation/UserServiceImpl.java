package com.java.assignment4.Service.Implementation;

import com.java.assignment4.Model.User;
import com.java.assignment4.Repo.UserRepo;
import com.java.assignment4.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        User user1=this.userRepo.save(user);
        return user1;
    }
}
