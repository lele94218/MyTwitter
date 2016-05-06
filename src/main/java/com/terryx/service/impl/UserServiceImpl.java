package com.terryx.service.impl;

import com.terryx.elasticsearch.service.SearchDataService;
import com.terryx.elasticsearch.service.TweetDataService;
import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.repository.UserRepository;
import com.terryx.service.CorpusService;
import com.terryx.service.TweetService;
import com.terryx.service.UserService;
import com.terryx.utils.MapSort;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
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

    public void updateRcmdUserIds(String rcmdUserIds, int userId) {
        userRepository.updateRcmdUserIds(rcmdUserIds, userId);
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

    public Map<Integer, Double> getRecommendUserIds(int userId, int number) throws Exception {
        Map<Integer, Double> recommendUserIdsMap = new HashMap<Integer, Double>();
        UserEntity userEntity = findById(userId);
        Collection<TweetEntity> tweetEntities = userEntity.getTweetsById();
        for (TweetEntity tweetEntity : tweetEntities) {
            LOGGER.info("Compare with " + tweetEntity.getTweetId() + ": " + tweetEntity.getRawText());
            String rawText = tweetEntity.getRawText();
            List<Map<String, Object>> results = searchDataService.getResult(rawText, userId, 0, number, null);
            for (Map<String, Object> result : results) {
                Integer _userId = (Integer) result.get("user_id");
                if (recommendUserIdsMap.containsKey(_userId)) {
                    Double tmp = recommendUserIdsMap.get(_userId) + (Double) result.get("score");
                    recommendUserIdsMap.put(_userId, tmp);
                } else {
                    recommendUserIdsMap.put(_userId, (Double) result.get("score"));
                }
            }
        }
        return MapSort.sortMap(recommendUserIdsMap);
    }

    public Map<Integer, Double> getTopRecommendUserIds(int userId, int number, int top) throws Exception {
        Map<Integer, Double> resultMap = new HashMap<Integer, Double>();

        UserEntity userEntity = findById(userId);
        String ids = userEntity.getRcmdUserIds();
        if (ids == null || StringUtils.isEmpty(ids)) {
            Map<Integer, Double> map = getRecommendUserIds(userId, number);
            int cnt = top;
            for (Map.Entry<Integer, Double> mapEntry : map.entrySet()) {
                if (cnt-- <= 0) break;
                resultMap.put(mapEntry.getKey(), mapEntry.getValue());
            }
            saveTopRecommendUserIds(userId, resultMap);
        } else {
            String [] resultGroup = StringUtils.split(ids, ",");
            for (String result : resultGroup) {
                String [] _result = StringUtils.split(result, ":");
                Integer _id = Integer.parseInt(_result[0]);
                Double _double = Double.parseDouble(_result[1]);
                resultMap.put(_id, _double);
            }
        }
        return MapSort.sortMap(resultMap);
    }

    public void saveTopRecommendUserIds(int userId, Map<Integer, Double> resultMap) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Double> mapEntry : resultMap.entrySet()) {
            int _userId = mapEntry.getKey();
            sb.append(_userId).append(":").append(mapEntry.getValue().toString()).append(",");
        }
        updateRcmdUserIds(sb.toString(), userId);
    }
}
