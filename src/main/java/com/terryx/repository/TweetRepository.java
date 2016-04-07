package com.terryx.repository;

import com.terryx.model.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xueta on 2016/3/24.
 */
public interface TweetRepository extends JpaRepository<TweetEntity, Integer> {
    @Modifying
    @Transactional
    @Query("update TweetEntity tw set tw.rawText=:qRawText where tw.tweetId =:qId")
    public void updateRawText(@Param("qRawText") String rawText, @Param("qId") int id);
}
