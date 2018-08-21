package com;

import com.water.example.donain.User;
import com.water.example.mapper.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {

    @Autowired
    UserRepository repository;

    @Test
    public void  test(){
        User user = repository.findUser((long) 1);
        System.out.println(user.getCard_id());
    }
}
