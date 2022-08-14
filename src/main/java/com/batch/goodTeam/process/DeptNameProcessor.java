package com.batch.goodTeam.process;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.goodTeam.entity.MyUser;


public class DeptNameProcessor {

    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public DeptNameProcessor() {
        DEPT_NAMES.put("001", "會計部");
        DEPT_NAMES.put("002", "財務部");
        DEPT_NAMES.put("003", "資訊部");
    }

    // Override ItemProcessor
    // to make deptCode -> dept by using this processor
   
}
