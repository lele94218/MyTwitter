package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.IndexDataService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

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
    public void addOrUpdateDoc() throws Exception {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("name", "wangwang");
        values.put("sex", "female");
        values.put("age", 2199);
        boolean flag = indexDataService.addOrUpdateDoc("megacorp", "student", values);
        LOGGER.info(flag);
    }
}