package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.IndexDataService;
import com.terryx.elasticsearch.service.TweetDataService;
import com.terryx.model.TweetEntity;
import com.terryx.service.TweetService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xueta on 2016/4/7 14:57.
 */
@Service
public class TweetDataServiceImpl implements TweetDataService {
    private static final Logger LOGGER = Logger.getLogger(TweetDataServiceImpl.class);

    @Autowired
    private IndexDataService indexDataService;
    @Autowired
    private TweetService tweetService;

    private static final String tweetDataIndices = "test-wordnet";
    private static final String tweetDataType = "tweets";

    public void addTweetDataByTweetId(int TweetId) {
        TweetEntity tweetEntity = tweetService.findById(TweetId);
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("tweet_id", tweetEntity.getTweetId());
        values.put("raw_text", tweetEntity.getRawText());
        values.put("user_id", tweetEntity.getUserById().getUserId());
        values.put("create_at", tweetEntity.getCreatedAt());

        boolean flag = indexDataService.addOrUpdateDoc(tweetDataIndices, tweetDataType, values);
        if (!flag) {
            LOGGER.error(TweetId + " tweets failed to insert es");
        }
    }
}
