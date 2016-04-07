package com.terryx.service;

import com.terryx.model.UserEntity;

/**
 * Created by xueta on 2016/3/26 17:42.
 */
public interface UserService extends BaseService<UserEntity> {
    /**
     * 对每一用户的所有推文进行加入语料库
     * 效率太低, 暂不使用
     *
     * @param userId
     */
    public void doTweetsToCorpusByUserId(int userId) throws Exception;

    /**
     * 对一用户的所有推文进行处理并更新 tweets 表的 raw_text 列
     * 暂定使用该方法对推文语料进行维护
     *
     * @param userId
     * @throws Exception
     */
    public void doTweetsToRawTextByUserId(int userId) throws Exception;

    /**
     * 对用户的所有推文, 将 raw_text 加入 es
     *
     * @param userId
     * @throws Exception
     */
    public void AddTweetsToEsByUserId(int userId) throws Exception;
}
