package com.java.assignment.java8.Repository.Interfaces;

import com.java.assignment.java8.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    @Transactional
    @Query(nativeQuery = true, value = "select * from project where user_id = ?1")
    Project findOnById(int id);
}
