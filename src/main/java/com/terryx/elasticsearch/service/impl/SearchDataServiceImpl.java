package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.SearchDataService;
import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xueta on 2016/4/10 11:06.
 */
@Service
public class SearchDataServiceImpl implements SearchDataService {
    private static final Logger LOGGER = Logger.getLogger(SearchDataServiceImpl.class);

    @Autowired
    Client client;

    public List<Map<String, Object>> getResult(String keyword, int userId, int from, int size, Map<String, String> params) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        if (client == null)
            LOGGER.error("Client is null!");
        SearchResponse response = client.prepareSearch("test-wordnet")
                .setTypes("tweets")
                .setQuery(QueryBuilders.termQuery("raw_text", keyword))
                // 过滤到当前 user_id
                .setPostFilter(FilterBuilders.boolFilter().mustNot(FilterBuilders.termFilter("user_id", userId)))
                .setFrom(from).setSize(size).setExplain(true)
                .execute()
                .actionGet();

        SearchHit[] searchHits = response.getHits().getHits();
        for (SearchHit searchHit : searchHits) {
            Map<String, Object> map = new HashMap<String, Object>();
            String rawText = (String) searchHit.getSource().get("raw_text");
            Integer tweetId = (Integer) searchHit.getSource().get("tweet_id");
            String createAt = (String) searchHit.getSource().get("create_at");
            Integer t_userId = (Integer) searchHit.getSource().get("user_id");
            double score = searchHit.getScore();
            //LOGGER.info(rawText + "  " + score);
            map.put("score", score);
            map.put("raw_text", rawText);
            map.put("tweet_id", tweetId);
            map.put("create_at", createAt);
            map.put("user_id", t_userId);
            resultList.add(map);
        }
        return resultList;
    }
}
