package com.terryx.elasticsearch.service;

import org.elasticsearch.action.search.SearchResponse;

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
     * @param resultFields
     * @param urlField
     * @param from
     * @param params
     * @return
     */
    public List<Map<String, Object>> getResult(String keyword, String resultFields, String urlField, int from,
                                               Map<String, String> params);
}
