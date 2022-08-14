package com.batch.goodTeam.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.goodTeam.entity.MyUser;
import com.batch.goodTeam.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<MyUser> {
	
	@Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends MyUser> users) throws Exception{
        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
