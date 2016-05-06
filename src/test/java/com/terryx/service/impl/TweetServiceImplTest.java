package com.terryx.service.impl;

import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.service.TweetService;
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

import java.sql.Timestamp;

/**
 * Created by xueta on 2016/3/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TweetServiceImplTest {
    private final static Logger LOGGER = Logger.getLogger(TweetServiceImplTest.class);

    @Autowired
    TweetService tweetService;
    @Autowired
    UserService userService;

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

    @Test
    public void updateRawText() throws Exception {
        tweetService.updateRawText("haha", 1021);
    }

    @Test
    public void generateAndSaveRawText() throws Exception {
        tweetService.generateAndSaveRawText(1021);
    }

    @Test
    public void findByUserId() throws Exception {
        Sort sort = new Sort(Sort.Direction.ASC, "tweetId");
        Pageable pageable = new PageRequest(1, 10, sort);
        UserEntity userEntity = userService.findById(1095);
        Page<TweetEntity> tweetEntityPage = tweetService.findByUserById(userEntity, pageable);
        for (TweetEntity tweetEntity : tweetEntityPage) {
            LOGGER.info(tweetEntity.getRawText());
        }

    }
}