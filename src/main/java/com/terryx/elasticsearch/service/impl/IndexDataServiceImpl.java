package com.terryx.elasticsearch.service.impl;

import com.terryx.elasticsearch.service.IndexDataService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by xueta on 2016/4/1 16:35.
 */
@Service
public class IndexDataServiceImpl implements IndexDataService {

    @Autowired
    private TransportClient client;

    public boolean hasClient() {
        return this.client == null;
    }

    public boolean deleteDocByType(String indice, String type) {
        return false;
    }

    public boolean deleteDocByIds(String indice, String type, String... ids) {
        return false;
    }

    public boolean addOrUpdateDoc(String indice, String type, Map<String, Object> values) {
        return false;
    }

    public Map<String, Object> findById(String indice, String type, String id) {
        return null;
    }
}
