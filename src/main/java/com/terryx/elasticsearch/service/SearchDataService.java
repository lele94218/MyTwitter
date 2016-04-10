package com.terryx.elasticsearch.service;

import java.util.List;
import java.util.Map;

/**
 * Created by xueta on 2016/4/10 11:02.
 */
public interface SearchDataService {
    /**
     * 获取搜索结果
     *
     * @param keyword
     * @param userId
     * @param from
     * @param size
     * @param params
     * @return
     */
    public List<Map<String, Object>> getResult(String keyword, int userId, int from, int size, Map<String, String> params);
}
