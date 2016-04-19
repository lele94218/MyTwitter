package com.terryx.service.impl;

import com.terryx.elasticsearch.service.SearchDataService;
import com.terryx.elasticsearch.service.TweetDataService;
import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.repository.UserRepository;
import com.terryx.service.CorpusService;
import com.terryx.service.TweetService;
import com.terryx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xueta on 2016/3/26 20:33.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    CorpusService corpusService;
    @Autowired
    TweetService tweetService;
    @Autowired
    TweetDataService tweetDataService;
    @Autowired
    SearchDataService searchDataService;

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void save(List<UserEntity> userEntities) {
        userRepository.save(userEntities);
    }

    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    public void deleteById(Integer id) {
        userRepository.delete(id);
    }

    public UserEntity findById(Integer id) {
        return userRepository.findOne(id);
    }

    public void update(UserEntity userEntity) {
        //TODO
    }

    public Page<UserEntity> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void doTweetsToCorpusByUserId(int userId) throws Exception {
        UserEntity userEntity = findById(userId);
        Collection<TweetEntity> tweetEntities = userEntity.getTweetsById();
        for (TweetEntity tweetEntity : tweetEntities) {
            corpusService.doCorpusByTweetId(tweetEntity.getTweetId());
            LOGGER.info("Insert into corpus: " + tweetEntity.getTwTweetId());
        }
    }

    public void doTweetsToRawTextByUserId(int userId) throws Exception {
        UserEntity userEntity = findById(userId);
        Collection<TweetEntity> tweetEntities = userEntity.getTweetsById();
        for (TweetEntity tweetEntity : tweetEntities) {
            int tweetId = tweetEntity.getTweetId();
            tweetService.generateAndSaveRawText(tweetId);
            LOGGER.info(userId + " update raw_text: " + tweetId);
        }
    }

    public void AddTweetsToEsByUserId(int userId) throws Exception {
        UserEntity userEntity = findById(userId);
        Collection<TweetEntity> tweetEntities = userEntity.getTweetsById();
        for (TweetEntity tweetEntity : tweetEntities) {
            int tweetId = tweetEntity.getTweetId();
            tweetDataService.addTweetDataByTweetId(tweetId);
            LOGGER.info(userId + " add raw_text to es: " + tweetId);
        }
    }

    public void saveRecommendUserIds(int userId, int number) throws Exception {
        Map<String, Double> recommendUserIdsMap = new HashMap<String, Double>();
        UserEntity userEntity = findById(userId);
        Collection<TweetEntity> tweetEntities = userEntity.getTweetsById();
        for (TweetEntity tweetEntity : tweetEntities) {
            String rawText = tweetEntity.getRawText();
            List<Map<String, Object>> results = searchDataService.getResult(rawText, userId, 0, number, null);
            for (Map<String, Object> result : results) {
                String _userId = (String) result.get("user_id");
                if (recommendUserIdsMap.containsKey(_userId)) {
                    Double tmp = recommendUserIdsMap.get(_userId) + (Double) result.get("score");
                    recommendUserIdsMap.put(_userId, (Double) result.get("score"));
                } else {
                    recommendUserIdsMap.put(_userId, (Double) result.get("score"));
                }
            }
        }

    }
}
