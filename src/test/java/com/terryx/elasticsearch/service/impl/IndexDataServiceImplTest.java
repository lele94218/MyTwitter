package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.IndexDataService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by xueta on 2016/4/5 11:07.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class IndexDataServiceImplTest {

    private static final Logger LOGGER = Logger.getLogger(IndexDataServiceImplTest.class);

    @Autowired
    private IndexDataService indexDataService;

    @Test
    public void test1() {
        LOGGER.info(indexDataService.hasClient());
    }
}