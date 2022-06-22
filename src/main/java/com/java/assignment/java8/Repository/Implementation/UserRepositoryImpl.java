package com.java.assignment.java8.Repository.Implementation;

import com.java.assignment.java8.Model.Project;
import com.java.assignment.java8.Model.Response;
import com.java.assignment.java8.Model.UserData;
import com.java.assignment.java8.Repository.Interfaces.ProjectRepository;
import com.java.assignment.java8.Repository.Interfaces.UserRepositoryIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl {

    @Autowired
    private UserRepositoryIn userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public String saveData(String name, int id, String projId, String projectName) {
        try {
            UserData user = new UserData();
            Project project = new Project();
            user.setUserName(name);
            user.setUserId(id);
            project.setProjectId(projId);
            project.setProjectName(projectName);
            project.setUserId(id);
            userRepository.save(user);
            projectRepository.save(project);
            return "Save Successful";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save Unsuccessful";
    }

    public Response getData(int id) {
        try{
            UserData user = null;
            Project project = null;
            user = userRepository.findOneById(id);
            project = projectRepository.findOnById(id);
            Response response = new Response(user, project);
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
