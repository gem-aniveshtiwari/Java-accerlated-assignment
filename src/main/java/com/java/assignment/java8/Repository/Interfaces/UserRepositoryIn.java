package com.java.assignment.java8.Repository.Interfaces;

import com.java.assignment.java8.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepositoryIn extends JpaRepository<UserData, String> {
    @Transactional
    @Query(nativeQuery = true, value = "select * from userdata where user_id = ?1")
    UserData findOneById(int id);
}
