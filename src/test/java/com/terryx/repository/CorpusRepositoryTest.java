package com.terryx.repository;

import com.terryx.model.CorpusEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xueta on 2016/3/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CorpusRepositoryTest {

    @Autowired
    CorpusRepository corpusRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testInsertIntoCorpus() {
        CorpusEntity corpusEntity = new CorpusEntity();
        corpusEntity.setWord("this");
        corpusEntity.setCount(1);
        corpusEntity.setUserById(userRepository.findOne(1096));
        corpusEntity.setLatestTime(new Timestamp(new Date().getTime()));
        corpusRepository.save(corpusEntity);
    }

}