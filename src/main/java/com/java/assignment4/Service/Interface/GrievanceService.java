package com.java.assignment4.Service.Interface;

import com.java.assignment4.Model.Grievance;

import java.util.Map;

public interface GrievanceService {
    public Map<String, Object> saveComplain(Grievance grievance);
}
