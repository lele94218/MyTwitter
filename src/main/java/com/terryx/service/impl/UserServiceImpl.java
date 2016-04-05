package com.terryx.service.impl;

import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import com.terryx.repository.UserRepository;
import com.terryx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by xueta on 2016/3/26 20:33.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


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

    public void doTweetsToCorpusByUserId(int id) {
        UserEntity userEntity = findById(id);
        Collection<TweetEntity> tweetEntities = userEntity.getTweetsById();
        //TODO
        System.out.println(tweetEntities.size());
    }
}
