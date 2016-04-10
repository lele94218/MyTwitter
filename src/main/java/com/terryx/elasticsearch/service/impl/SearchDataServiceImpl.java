package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.SearchDataService;
import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Map<String, Object>> getResult(String keyword, String resultFields, String urlField, int from, Map<String, String> params) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        if (client == null)
            LOGGER.error("Client is null!");
        SearchResponse response = client.prepareSearch("test-wordnet")
                .setTypes("tweets")
                .setQuery(QueryBuilders.termQuery("raw_text", "peopl"))                 // Query
                //.setPostFilter((Map) QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();

        SearchHit[] searchHits = response.getHits().getHits();
        for (int i = 0; i < searchHits.length; ++i) {
            String str = (String) searchHits[i].getSource().get("raw_text");
            double score = searchHits[i].getScore();
            LOGGER.info(str + "  " + score);
        }
        return null;
    }
}
