package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.SearchDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xueta on 2016/4/10 11:20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SearchDataServiceImplTest {
    @Autowired
    SearchDataService searchDataService;

    @Test
    public void getResult() throws Exception {
        searchDataService.getResult("dayton funnybone good chance ill sitting entire show tonight dayton ", 1113, 0, 10, null);
    }
}