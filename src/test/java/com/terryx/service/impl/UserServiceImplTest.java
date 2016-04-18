package com.terryx.service.impl;

import com.terryx.model.UserEntity;
import com.terryx.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xueta on 2016/3/26 20:42.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserServiceImplTest {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImplTest.class);

    @Autowired
    UserService userService;

    @Test
    public void testDoTweetsToCorpusByUserId() throws Exception {
        userService.doTweetsToCorpusByUserId(1095);
    }

    @Test
    public void doTweetsToRawTextByUserId() throws Exception {
        userService.doTweetsToRawTextByUserId(1095);
    }

    @Test
    public void addTweetsToEsByUserId() throws Exception {
        userService.AddTweetsToEsByUserId(1095);
    }

    @Test
    public void doAllData() throws Exception {
        int start = 1148, end = 1364;
        for (int i = start; i <= end; ++i) {
            userService.doTweetsToRawTextByUserId(i);
//            userService.AddTweetsToEsByUserId(i);
        }
//       userService.AddTweetsToEsByUserId(1115);
    }

    @Test
    public void findAll() throws Exception {
        Sort sort = new Sort(Sort.Direction.ASC, "userId");
        Pageable pageable = new PageRequest(1, 10, sort);
        Page<UserEntity> userEntityPage = userService.findAll(pageable);
        for (UserEntity userEntity : userEntityPage) {
            LOGGER.info(userEntity.getName());
        }

    }
}