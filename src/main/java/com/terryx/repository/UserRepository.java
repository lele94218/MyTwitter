package com.terryx.repository;

import com.terryx.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xueta on 2016/3/24.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByName(String name);
}
