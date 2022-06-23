package com.java.assignment.java8.Service.Implementation;

import com.java.assignment.java8.Model.Response;
import com.java.assignment.java8.Repository.Implementation.UserRepositoryImpl;
import com.java.assignment.java8.Service.Interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Async
    public CompletableFuture<String> saveData(String name, int id, String projId, String projectName) {
        log.debug("Inside UserServiceImp.saveData with : " + name + " " + id + " " + projId + " " + projectName);
        return userRepositoryImpl.saveData(name, id, projId, projectName);
    }

    @Override
    @Async
    public CompletableFuture<Response> getData(int id) {
        log.debug("Inside UserServiceImp.getData with : " + id);
        return userRepositoryImpl.getData(id);
    }
}
