package com.terryx.repository;

import com.terryx.model.CorpusEntity;
import com.terryx.model.TweetEntity;
import com.terryx.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;

/**
 * Created by xueta on 2016/3/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindUser() throws UnsupportedEncodingException {
        UserEntity userEntity = userRepository.findOne(1109);
        String ds = userEntity.getDescription();
        String dds = URLDecoder.decode(ds, "UTF-8");
        System.out.println(dds);

    }

    @Test
    public void testFindByName() throws Exception {
        UserEntity userEntity = userRepository.findByName("Xue Taoran");
        System.out.println(userEntity.getUserId());
    }

    @Test
    public void testFindTweetsById() {
        UserEntity userEntity = userRepository.findOne(1095);
        Collection<TweetEntity> tweetEntityCollection = userEntity.getTweetsById();
        System.out.println(tweetEntityCollection.size());
    }

    @Test
    public void testFindCorpusById() {
        UserEntity userEntity = userRepository.findOne(1096);
        Collection<CorpusEntity> corpusEntityCollection = userEntity.getCorpusesById();
        System.out.println(corpusEntityCollection.size());
    }
}