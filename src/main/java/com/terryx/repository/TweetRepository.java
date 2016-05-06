package com.terryx.repository;

import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    void updateRawText(@Param("qRawText") String rawText, @Param("qId") int id);

    Page<TweetEntity> findByUserById(UserEntity userEntity, Pageable pageable);
}
