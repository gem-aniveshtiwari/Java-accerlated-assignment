package com.java.assignment.java8.Service.Implementation;

import com.java.assignment.java8.Model.Response;
import com.java.assignment.java8.Repository.Implementation.UserRepositoryImpl;
import com.java.assignment.java8.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    public String saveData(String name, int id, String projId, String projectName) {
        return userRepositoryImpl.saveData(name, id, projId, projectName);
    }

    @Override
    public Response getData(int id) {
        return userRepositoryImpl.getData(id);
    }
}
