package com.java.assignment4.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long grievanceId;
    String grievance;
}
