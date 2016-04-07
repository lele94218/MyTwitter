package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.TweetDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xueta on 2016/4/7 15:30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TweetDataServiceImplTest {
    @Autowired
    private TweetDataService tweetDataService;

    @Test
    public void addTweetDataByTweetId() throws Exception {
        tweetDataService.addTweetDataByTweetId(1021);
    }
}