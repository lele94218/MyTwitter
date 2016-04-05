package com.terryx.repository;

import com.terryx.model.UserSimEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xueta on 2016/3/24.
 */
public interface UserSimRepository extends JpaRepository<UserSimEntity, Integer> {
}
