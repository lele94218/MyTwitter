package com.terryx.service;

import java.util.List;

/**
 * Created by xueta on 2016/3/25.
 */
public interface BaseService<T> {
    public void save(T t);

    public void save(List<T> ts);

    public void delete(T t);

    public void deleteById(Integer id);

    public T findById(Integer id);

    public void update(T t);
}
