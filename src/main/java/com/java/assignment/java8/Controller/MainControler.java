package com.java.assignment.java8.Controller;
import com.java.assignment.java8.Model.Response;
import com.java.assignment.java8.Service.Interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = "/java")
public class MainControler {

    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public CompletableFuture<ResponseEntity<String>> saveData(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "id") int id,
            @RequestParam(value = "projId") String projId,
            @RequestParam(value = "projectName") String projectName){
        log.info("Inside /save with parameters : " + name + " " + id + " " + projId + " " + projId);
        return userService.saveData(name, id, projId, projectName).thenApply(ResponseEntity::ok);
    }

    @PostMapping("/getData")
    public CompletableFuture<ResponseEntity<Response>> getData(
            @RequestParam(value = "id") int id){
        log.info("Inside /getData with parameters : " + id);
        return userService.getData(id).thenApply(ResponseEntity::ok);
    }
}
