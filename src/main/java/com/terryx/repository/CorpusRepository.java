package com.terryx.repository;

import com.terryx.model.CorpusEntity;
import com.terryx.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xueta on 2016/3/25 17:34.
 */
public interface CorpusRepository extends JpaRepository<CorpusEntity, Integer> {
    public List<CorpusEntity> findByWord(String word);

    public List<CorpusEntity> findByWordAndUserById(String word, UserEntity userEntity);
}
