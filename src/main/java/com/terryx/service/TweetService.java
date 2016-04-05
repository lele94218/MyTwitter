package com.terryx.service;

import com.terryx.model.TweetEntity;

/**
 * Created by xueta on 2016/3/25.
 */
public interface TweetService extends BaseService<TweetEntity> {

    /**
     *根据 tweet id 查找对应 tweet 文本信息
     * @param id
     * @return
     */
    public String getTextByTweetId(int id);
}
