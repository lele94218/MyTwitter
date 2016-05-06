package com.terryx.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.terryx.jsonview.Views;
import com.terryx.model.SimilarEntity;
import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.model.criteria.PageCriteria;
import com.terryx.model.criteria.RecommendUsersCriteria;
import com.terryx.model.criteria.UserCriteria;
import com.terryx.service.TweetService;
import com.terryx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * json 控制器
 * Created by xueta on 2016/4/12 15:20.
 */
@RestController
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    TweetService tweetService;

    /**
     * 用户列表
     *
     * @param page 页面参数
     * @return 分页
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Page<UserEntity> getUsersByPage(@RequestBody PageCriteria page) {
        Sort sort = new Sort(Sort.Direction.ASC, "userId");
        Pageable pageable = new PageRequest(page.getPage(), page.getSize(), sort);
        return userService.findAll(pageable);
    }

    /**
     * 推荐用户
     *
     * @param usersCriteria 推荐用户参数
     * @return json
     * @throws Exception
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/recommend-users", method = RequestMethod.POST)
    public List<SimilarEntity> getRecommendUsersByPage(@RequestBody RecommendUsersCriteria usersCriteria) throws Exception {
        Map<Integer, Double> resultMap =
                userService.getTopRecommendUserIds(usersCriteria.getUserId(), usersCriteria.getNumber(), usersCriteria.getTop());
        List<SimilarEntity> userEntities = new ArrayList<SimilarEntity>();
        for (Map.Entry<Integer, Double> mapEntry : resultMap.entrySet()) {
            SimilarEntity similarEntity = new SimilarEntity();
            similarEntity.setUserEntity(userService.findById(mapEntry.getKey()));
            similarEntity.setSimilarity(mapEntry.getValue());

            userEntities.add(similarEntity);
        }
        return userEntities;
    }

    /**
     * 用户推文
     *
     * @param userCriteria 用户相关参数
     * @return 分页
     * @throws Exception
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/tweets-by-id", method = RequestMethod.POST)
    public Page<TweetEntity> getTweetByUserIdByPage(@RequestBody UserCriteria userCriteria) throws Exception {
        Sort sort = new Sort(Sort.Direction.ASC, "tweetId");
        Pageable pageable = new PageRequest(userCriteria.getPage(), userCriteria.getSize(), sort);
        UserEntity userEntity = userService.findById(userCriteria.getUserId());
        return tweetService.findByUserById(userEntity, pageable);
    }

}
