package com.terryx.service;

import com.terryx.model.UserEntity;

/**
 * Created by xueta on 2016/3/26 17:42.
 */
public interface UserService extends BaseService<UserEntity> {
    /**
     * 对每一用户的所有推文进行加入语料库
     *
     * @param id
     */
    public void doTweetsToCorpusByUserId(int id);
}
