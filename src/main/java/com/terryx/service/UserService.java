package com.terryx.service;

import com.terryx.model.UserEntity;

import java.util.Map;

/**
 * Created by xueta on 2016/3/26 17:42.
 */
public interface UserService extends BaseService<UserEntity> {
    /**
     * 更新推荐用户
     *
     * @param rcmdUserIds 推荐用户
     * @param userId      用户 id
     */
    public void updateRcmdUserIds(String rcmdUserIds, int userId);

    /**
     * 对每一用户的所有推文进行加入语料库
     * 效率太低, 暂不使用
     *
     * @param userId
     */
    void doTweetsToCorpusByUserId(int userId) throws Exception;

    /**
     * 对一用户的所有推文进行处理并更新 tweets 表的 raw_text 列
     * 暂定使用该方法对推文语料进行维护
     *
     * @param userId
     * @throws Exception
     */
    void doTweetsToRawTextByUserId(int userId) throws Exception;

    /**
     * 对用户的所有推文, 将 raw_text 加入 es
     *
     * @param userId
     * @throws Exception
     */
    void AddTweetsToEsByUserId(int userId) throws Exception;

    /**
     * 得到相似用户 ids, 返回结果排序后 map
     *
     * @param number 相似用户数量
     * @param userId 用户 id
     * @return
     * @throws Exception
     */
    Map<Integer, Double> getRecommendUserIds(int userId, int number) throws Exception;

    /**
     * 得到最相似 Top 的推荐用户, 如果数据库已存取出, 否则计算后存入
     *
     * @param userId 用户 id
     * @param number 查询相似推文数量
     * @param top    返回前 top 名的用户
     * @return
     * @throws Exception
     */
    Map<Integer, Double> getTopRecommendUserIds(int userId, int number, int top) throws Exception;

    /**
     * 保存结果到数据库
     *
     * @param userId    用户 id
     * @param resultMap 结果 map
     * @throws Exception
     */
    void saveTopRecommendUserIds(int userId, Map<Integer, Double> resultMap) throws Exception;
}
