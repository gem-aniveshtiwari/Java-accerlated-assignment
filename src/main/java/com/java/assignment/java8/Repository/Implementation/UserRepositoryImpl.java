package com.java.assignment.java8.Repository.Implementation;

import com.java.assignment.java8.Model.AuditTable;
import com.java.assignment.java8.Model.Project;
import com.java.assignment.java8.Model.Response;
import com.java.assignment.java8.Model.UserData;
import com.java.assignment.java8.Repository.Interfaces.AuditableRepository;
import com.java.assignment.java8.Repository.Interfaces.ProjectRepository;
import com.java.assignment.java8.Repository.Interfaces.UserRepositoryIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Repository
@Slf4j
public class UserRepositoryImpl {

    @Autowired
    private UserRepositoryIn userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private AuditableRepository auditableRepository;

    public CompletableFuture<String> saveData(String name, int id, String projId, String projectName) {
        log.debug("Inside UserRepositoryImpl.saveData with : " + name + " " + id + " " + projId + " " + projectName);
        try {
            UserData user = new UserData();
            Project project = new Project();
            AuditTable auditTable = new AuditTable();
            user.setUserName(name);
            user.setUserId(id);
            project.setProjectId(projId);
            project.setProjectName(projectName);
            project.setUserId(id);
            auditTable.setCreatedBy(name);
            auditTable.setCreatedDate(Date.from(Instant.now()));
            auditTable.setLastModifiedBy(null);
            auditTable.setLastModifiedDate(null);
            userRepository.save(user);
            projectRepository.save(project);
            auditableRepository.save(auditTable);
            return CompletableFuture.completedFuture("Save Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Save Unsuccessful");
    }

    public CompletableFuture<Response> getData(int id) {
        log.debug("Inside UserRepositoryImpl.getData with : " + id);
        try{
            UserData user = null;
            Project project = null;
            user = userRepository.findOneById(id);
            project = projectRepository.findOnById(id);
            Response response = new Response(user, project);
            return CompletableFuture.completedFuture(response);
        }catch (Exception e){
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(null);
    }
}
