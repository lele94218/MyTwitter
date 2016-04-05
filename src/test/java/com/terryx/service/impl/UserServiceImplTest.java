package com.terryx.service.impl;

import com.terryx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xueta on 2016/3/26 20:42.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void testDoTweetsToCorpusByUserId() throws Exception {
        userService.doTweetsToCorpusByUserId(1095);
    }
}