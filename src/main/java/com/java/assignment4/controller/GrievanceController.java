package com.java.assignment4.controller;

import com.java.assignment4.Model.Grievance;
import com.java.assignment4.Service.Interface.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GrievanceController {

    @Autowired
    GrievanceService grievanceService;

    @PostMapping("/complain")
    public ResponseEntity<?> grievanceApi(@RequestBody Map<String, String> requestPayload) {
        Grievance grievance = new Grievance();
        if (requestPayload.get("grievance") != null) {
            grievance.setGrievance(requestPayload.get("grievance"));
        }

        return ResponseEntity.ok(this.grievanceService.saveComplain(grievance));
    }
}
