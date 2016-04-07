package com.terryx.service;

import com.terryx.model.CorpusEntity;
import com.terryx.model.UserEntity;

import java.util.List;

/**
 * Created by xueta on 2016/3/25.
 */
public interface CorpusService extends BaseService<CorpusEntity> {

    /**
     * 根据 单词 和 用户 查找对应语料
     * @param word
     * @param userEntity
     * @return
     */
    List<CorpusEntity> findByWordAndUserById(String word, UserEntity userEntity);
    /**
     * 根据单词查找语料库信息
     *
     * @param word
     * @return
     */
    List<CorpusEntity> findByWord(String word);

    /**
     * 在 corpus 表中进行存储, 并追加 user_ids
     *
     * @param word   语义处理后的每个单词
     * @param userEntity 该单词所属的用户
     */
    public void doWordMarkToCorpus(String word, UserEntity userEntity);

    /**
     * 对每条 tweet 文本调用语义处理, 得到单词的集合, 然后将单词标记到 corpus 表
     *
     * @param tweetId tweet 表中的 id
     */
    public void doCorpusByTweetId(int tweetId) throws Exception;
}
