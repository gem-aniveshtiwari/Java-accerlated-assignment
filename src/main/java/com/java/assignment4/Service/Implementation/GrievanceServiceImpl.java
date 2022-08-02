package com.java.assignment4.Service.Implementation;

import com.java.assignment4.Model.Grievance;
import com.java.assignment4.Repo.GrievanceRepo;
import com.java.assignment4.Service.Interface.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GrievanceServiceImpl implements GrievanceService {
    @Autowired
    GrievanceRepo grievanceRepo;

    @Override
    public Map<String, Object> saveComplain(Grievance grievance) {
        Map<String, Object> hashMap = new HashMap();
        try {
            Grievance grievance1 = this.grievanceRepo.save(grievance);
            hashMap.put("Status", "Success");
            hashMap.put("Response", grievance1);
        } catch (Exception exception) {
            hashMap.put("Status", "Failed");

        }
        return hashMap;
    }
}
