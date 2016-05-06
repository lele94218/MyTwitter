package com.terryx.service.impl;

import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.repository.TweetRepository;
import com.terryx.sematic.raw.TweetsTextProcessing;
import com.terryx.service.CorpusService;
import com.terryx.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        //TODO
    }

    public Page<TweetEntity> findAll(Pageable pageable) {
        return tweetRepository.findAll(pageable);
    }

    public void updateRawText(String rawText, int tweetId) {
        tweetRepository.updateRawText(rawText, tweetId);
    }

    public void generateAndSaveRawText(int tweetId) throws Exception {
        String text = getTextByTweetId(tweetId);
        List<String> words = TweetsTextProcessing.doTweetsTextProcessing(text);

        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word + " ");
        }

        updateRawText(stringBuilder.toString(), tweetId);
    }

    public Page<TweetEntity> findByUserById(UserEntity userEntity, Pageable pageable) {
        return tweetRepository.findByUserById(userEntity, pageable);
    }

    public String getTextByTweetId(int tweetId) {
        TweetEntity tweetEntity = findById(tweetId);

        return tweetEntity.getText();
    }
}
