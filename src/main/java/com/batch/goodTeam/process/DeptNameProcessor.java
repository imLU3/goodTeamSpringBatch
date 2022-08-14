package com.batch.goodTeam.process;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.goodTeam.entity.MyUser;

@Component
@StepScope
public class DeptNameProcessor implements ItemProcessor<MyUser, MyUser> {

    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public DeptNameProcessor() {
        DEPT_NAMES.put("001", "Technology");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Accounts");
    }

    @Override
    public MyUser process(MyUser user) throws Exception {
        String deptCode = user.getDept();
        String dept = DEPT_NAMES.get(deptCode);
        user.setDept(dept);
        user.setTime(new Date());
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
