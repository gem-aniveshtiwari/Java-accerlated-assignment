package com.java.assignment.java8.Service.Interfaces;

import com.java.assignment.java8.Model.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface UserService {
    CompletableFuture<String> saveData(String name, int id, String projId, String projectName);

    CompletableFuture<Response> getData(int id);
}
