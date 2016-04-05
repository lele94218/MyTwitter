package com.terryx.service.impl;

import com.terryx.model.TweetEntity;
import com.terryx.repository.TweetRepository;
import com.terryx.service.CorpusService;
import com.terryx.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xueta on 2016/3/25.
 */
@Service
public class TweetServiceImpl implements TweetService {
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private CorpusService corpusService;

    public void save(TweetEntity tweetEntity) {
        tweetRepository.save(tweetEntity);
    }

    public void save(List<TweetEntity> tweetEntities) {
        tweetRepository.save(tweetEntities);
    }

    public void delete(TweetEntity tweetEntity) {
        tweetRepository.delete(tweetEntity);
    }

    public void deleteById(Integer id) {
        tweetRepository.delete(id);
    }

    public TweetEntity findById(Integer id) {
        return tweetRepository.findOne(id);
    }

    public void update(TweetEntity tweetEntity) {
        //@TODO
    }

    public String getTextByTweetId(int id) {
        TweetEntity tweetEntity = findById(id);
        return tweetEntity.getText();
    }
}
