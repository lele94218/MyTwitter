package com.terryx.utils;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 排序测试
 * Created by xueta on 2016/4/19 14:09.
 */
public class MapSortTest {
    private final static Logger LOGGER = Logger.getLogger(MapSortTest.class);

    @Test
    public void sortMap() throws Exception {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("jack", 0.0);
        map.put("tom", -4.00);
        map.put("terry", -1.12);
        Map<String, Double> _map = MapSort.sortMap(map);
        for (Map.Entry<String, Double> m : _map.entrySet()) {
            LOGGER.info(m.getKey() + ": " + m.getValue());
        }
    }
}