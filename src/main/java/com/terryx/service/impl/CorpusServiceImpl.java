package com.terryx.service.impl;

import com.terryx.model.CorpusEntity;
import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.repository.CorpusRepository;
import com.terryx.sematic.raw.TweetsTextProcessing;
import com.terryx.service.CorpusService;
import com.terryx.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by xueta on 2016/3/25 12:43.
 */

@Service
public class CorpusServiceImpl implements CorpusService {
    @Autowired
    private CorpusRepository corpusRepository;

    @Autowired
    private TweetService tweetService;

    public void save(CorpusEntity corpusEntity) {
        corpusRepository.save(corpusEntity);
    }

    public void save(List<CorpusEntity> corpusEntities) {
        corpusRepository.save(corpusEntities);
    }

    public void delete(CorpusEntity corpusEntity) {
        corpusRepository.delete(corpusEntity);
    }

    public void deleteById(Integer id) {
        corpusRepository.delete(id);
    }

    public CorpusEntity findById(Integer id) {
        return corpusRepository.findOne(id);
    }

    public List<CorpusEntity> findByWordAndUserById(String word, UserEntity userEntity) {
        return corpusRepository.findByWordAndUserById(word, userEntity);
    }

    public List<CorpusEntity> findByWord(String word) {
        return corpusRepository.findByWord(word);
    }

    public void update(CorpusEntity corpusEntity) {
        //TODO
    }

    public void doWordMarkToCorpus(String word, UserEntity userEntity) {
//        List<CorpusEntity> corpusEntities = findByWordAndUserById(word, userEntity);
//        // 判断语料库中是否有这个单词
//        if (corpusEntities.size() > 0) {
//            // 若存在单词
//            CorpusEntity corpusEntity = corpusEntities.get(0);
//            int count = corpusEntity.getCount();
//            corpusEntity.setCount(count + 1);
//            save(corpusEntity);
//
//        } else {
//            // 若不存在单词, 新建一个单词
        CorpusEntity corpusEntity = new CorpusEntity();
        corpusEntity.setWord(word);
        corpusEntity.setUserById(userEntity);
        corpusEntity.setCount(1);
        corpusEntity.setLatestTime(new Timestamp(new Date().getTime()));
        save(corpusEntity);
//        }
    }

    public void doCorpusByTweetId(int tweetId) throws Exception {
        TweetEntity tweetEntity = tweetService.findById(tweetId);
        String text = tweetEntity.getText();
        UserEntity userEntity = tweetEntity.getUserById();

        Set<String> words = TweetsTextProcessing.doTweetsTextProcessing(text);
        for (String word : words) {
            doWordMarkToCorpus(word, userEntity);
        }
    }
}
