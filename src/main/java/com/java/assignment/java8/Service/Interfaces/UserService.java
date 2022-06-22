package com.java.assignment.java8.Service.Interfaces;

import com.java.assignment.java8.Model.Response;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String saveData(String name, int id, String projId, String projectName);

    Response getData(int id);
}
