package com.terryx.service;

import com.terryx.model.TweetEntity;

/**
 * Created by xueta on 2016/3/25.
 */
public interface TweetService extends BaseService<TweetEntity> {

    /**
     * 根据 tweet id 查找对应 tweet 文本信息
     *
     * @param tweetId
     * @return
     */
    public String getTextByTweetId(int tweetId);

    /**
     * 修改 raw_text 列
     *
     * @param rawText
     * @param tweetId
     */
    public void updateRawText(String rawText, int tweetId);

    /**
     * 对一条 tweet 处理得出对应 rawText
     *
     * @param tweetId
     * @throws Exception
     */
    public void generateAndSaveRawText(int tweetId) throws Exception;
}
