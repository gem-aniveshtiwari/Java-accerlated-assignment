package com.java.assignment.java8.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {
    @Id
    String projectId;
    String projectName;
    int userId;
}
