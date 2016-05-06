package com.terryx.service;

import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    /**
     * 查用户所有推文
     * @param userEntity
     * @param pageable
     * @return 分页
     */
    public Page<TweetEntity> findByUserById(UserEntity userEntity, Pageable pageable);
}
