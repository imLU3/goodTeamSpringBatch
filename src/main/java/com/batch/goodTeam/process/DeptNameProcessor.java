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
        DEPT_NAMES.put("001", "高雄");
        DEPT_NAMES.put("002", "台中");
        DEPT_NAMES.put("003", "台北");
    }

    // Override ItemProcessor
    // to make deptCode -> dept by using this processor
   
}
