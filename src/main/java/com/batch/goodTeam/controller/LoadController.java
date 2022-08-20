package com.batch.goodTeam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

    // @Autowired Job & Launcher

    @Autowired
    
    @GetMapping
    public Map<String, Object> load() throws Exception {
    	
    	System.out.println("Batch Starting...");
    	// create a Map to put a new JobParameter
     
        // JobParameters的參數會在整個JOB執行過程中被共用,
    	
        // Every time the batch is run, a new JobExecution is created
        
        
        System.out.println("Batch is Running...");
//        System.out.println("JobExecution: " + jobExecution.getStatus());
        Map<String, Object> finalStatus = new HashMap<>();
//        finalStatus.put("CreateTime", jobExecution.getCreateTime());
//        finalStatus.put("EndTime", jobExecution.getEndTime());
//        finalStatus.put("Status", jobExecution.getStatus());

        return finalStatus;
    }
}
