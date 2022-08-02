package com.java.assignment4.Repo;

import com.java.assignment4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
