package com.terryx.elasticsearch.service.impl;

import com.terryx.comms.Order;
import com.terryx.comms.Order.Direction;
import com.terryx.comms.Pageable;
import com.terryx.elasticsearch.service.IndexDataService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        validate(indice, type);
        DeleteByQueryResponse response = client.prepareDeleteByQuery(indice)
                .setQuery(QueryBuilders.termQuery("_type", type))
                .execute().actionGet();
        // 通过返回状态值, 判断是否正常删除
        return response.status().getStatus() == RestStatus.OK.getStatus();
    }


    public boolean deleteDocByIds(String indice, String type, String... ids) {
        // 如果只有一个 doc, 直接删除; 否则 bulk 批量删除
        if (ids.length == 1) {
            DeleteResponse actionGet = client.prepareDelete(indice, type, ids[0]).execute().actionGet();
            return actionGet.isFound();
        }
        return bulkDeleteByIds(indice, type, ids);
    }

    /**
     * 批量删除 doc
     *
     * @param indice
     * @param type
     * @param ids
     * @return
     */
    private boolean bulkDeleteByIds(String indice, String type, String[] ids) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        int count = 0;
        for (String id : ids) {
            bulkRequest.add(new DeleteRequest(indice, type, id));
            count++;
            // 分批量删除
            if (count > 1000) {
                BulkResponse bulkResponse = bulkRequest.execute().actionGet();
                if (bulkResponse.hasFailures()) {
                    //TODO 删除失败
                }
                count = 0;
            }
        }
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();

        if (bulkResponse.hasFailures()) {
            // TODO 删除失败
            return false;
        }

        return false;
    }

    public boolean addOrUpdateDoc(String indice, String type, Map<String, Object> values) {
        //if (isAliases(indice))
        //    return false;
        String id = (String) values.get("id");

        // 无 id 新增 Doc
        if (id == null || id.trim().length() == 0) {
            IndexResponse actionGet = client.prepareIndex(indice, type)
                    .setSource(values).execute().actionGet();
            return actionGet.isCreated();
        } else { // Add or Update
            IndexRequest indexRequest =
                    new IndexRequest(indice, type, (String) values.get("id"))
                            .source(values);
            UpdateRequest updateRequest =
                    new UpdateRequest(indice, type, (String) values.get("id"))
                            .upsert(indexRequest);
            UpdateResponse updateResponse = client.update(updateRequest).actionGet();
            return updateResponse.isCreated();
        }
    }

    private boolean isAliases(String indice) {
        return indice != null && indice.endsWith("-alias");
    }

    public Map<String, Object> findById(String indice, String type, String id) {
        GetResponse actionGet = client.prepareGet(indice, type, id).execute().actionGet();
        return actionGet.getSourceAsMap();
    }

    public Page<Map<String, Object>> findPage(Pageable pageable, String indice, String type) {
        int pageSize = pageable.getPageSize() > 0 ? pageable.getPageSize() : 20;
        int pageNumber = pageable.getPageNumber() > 0 ? pageable.getPageNumber() : 1;
        int start = (pageNumber - 1) * pageSize;

        SearchRequestBuilder request = client.prepareSearch(indice).setTypes(type).setFrom(start).setSize(pageSize);
        String orderProperty = pageable.getOrderProperty();
        if (!StringUtils.isEmpty(orderProperty)) {
            Direction orderDirection = pageable.getOrderDirection();
            if (orderDirection.compareTo(Direction.asc) == 0) {
                request.addSort(orderProperty, SortOrder.ASC);
            } else {
                request.addSort(orderProperty, SortOrder.DESC);
            }
        }
        // TODO
        return null;
    }

    private void validate(String... values) {
        for (String str : values) {
            Assert.hasText(str, "No value defined for Query");
        }
    }

}
