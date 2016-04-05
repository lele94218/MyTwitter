package com.terryx.repository;

import com.terryx.model.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xueta on 2016/3/24.
 */
public interface TweetRepository extends JpaRepository<TweetEntity, Integer> {

}
