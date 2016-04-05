package com.terryx.service.impl;

import com.terryx.model.CorpusEntity;
import com.terryx.repository.UserRepository;
import com.terryx.service.CorpusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xueta on 2016/3/25 20:32.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CorpusServiceImplTest {

    @Autowired
    CorpusService corpusService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByWord() throws Exception {
        List<CorpusEntity> corpusEntities = corpusService.findByWord("fds");
        if (corpusEntities.size() == 0) {
            System.out.println("it is null!!!");
        } else {
            System.out.println(corpusEntities.get(0).getCount());
            corpusEntities.get(0).setCount(12);
        }
    }

    @Test
    public void testDoWordMarkToCorpus() throws Exception {
        corpusService.doWordMarkToCorpus("fds", userRepository.getOne(1097));
        corpusService.doWordMarkToCorpus("hehe",userRepository.getOne(1096));
    }

    @Test
    public void testDoCorpusByTweetId() throws Exception {
        corpusService.doCorpusByTweetId(1021);
    }

    @Test
    public void testFindByWordAndUserId() throws Exception {
        List<CorpusEntity> corpusEntities = corpusService.findByWordAndUserById("as", userRepository.getOne(1096));
        System.out.println(corpusEntities.get(0).getCount());
    }
}