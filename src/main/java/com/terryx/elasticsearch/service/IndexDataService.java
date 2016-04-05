package com.terryx.elasticsearch.service;

import java.util.Map;

/**
 * Created by xueta on 2016/4/1 16:33.
 */
public interface IndexDataService {

    public boolean hasClient();
    /**
     * 根据索引及type来删除对应的文档（只删除所有文档，不会删除mapping）
     */
    public boolean deleteDocByType(String indice, String type);

    /**
     * 根据ids 来删除指定的doc
     */
    public boolean deleteDocByIds(String indice, String type, String... ids);

    /**
     * 根据索引与type来增加或者修改一个doc（根据id,if id ==0 then add if else update）
     */
    public boolean addOrUpdateDoc(String indice, String type, Map<String, Object> values);

    /**
     * 根据indice和type来查找文档
     */
    //public Page<Map<String, Object>> findPage(Pageable pageable, String indice, String type);

    /**
     * 根据id来查找文件信息
     */
    public Map<String, Object> findById(String indice, String type, String id);
}
