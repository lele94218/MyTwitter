package com.terryx.elasticsearch.service;

/**
 * Created by xueta on 2016/4/7 14:55.
 */
public interface TweetDataService {
    /**
     * 将一条推文加入 es 索引
     * @param TweetId
     */
    void addTweetDataByTweetId(int TweetId);
}
