package com.terryx.repository;

import com.terryx.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xueta on 2016/3/24.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByName(String name);

    @Modifying
    @Transactional
    @Query("update UserEntity us set us.rcmdUserIds=:qUserIds where us.userId =:qId")
    void updateRcmdUserIds(@Param("qUserIds") String rcmdUserIds, @Param("qId") int userId);
}
