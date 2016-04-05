package com.terryx.repository;

import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * Created by xueta on 2016/3/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindUser() {
        UserEntity userEntity = userRepository.findOne(1095);
        System.out.println(userEntity.getName());
    }

    @Test
    public void testFindByName() throws Exception {
        UserEntity userEntity = userRepository.findByName("Xue Taoran");
        System.out.println(userEntity.getUserId());
    }

    @Test
    public void testFindTweetsById() {
        UserEntity userEntity = userRepository.findOne(1095);
        Collection<TweetEntity> tweetEntityCollection = userEntity.getTweetsById();
        System.out.println(tweetEntityCollection.size());
    }
}