package com.java.assignment.java8.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "userdata")
@Getter
@Setter
public class UserData {
    @Id
    @NonNull
    int userId;

    String userName;
}
