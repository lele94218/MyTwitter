package com.terryx.service.impl;

import com.terryx.model.TweetEntity;
import com.terryx.service.TweetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * Created by xueta on 2016/3/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TweetServiceImplTest {

    @Autowired
    TweetService tweetService;

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testSave1() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {
        TweetEntity tweetEntity = tweetService.findById(1021);
        Timestamp timestamp = tweetEntity.getCreatedAt();
        System.out.println(timestamp.toString());
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGetTextByTweetId() throws Exception {
        String str = tweetService.getTextByTweetId(1021);
        System.out.println(str);
    }
}