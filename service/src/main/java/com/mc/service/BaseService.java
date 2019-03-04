package com.mc.service;

import java.util.List;

/**
 * 公共接口的方法放这里
 */
public interface BaseService<T> {
    void save(T eniity);
    void delete(T entity);
    void update(T entity);
    T findById(Integer id);
    List<T> getAll();
}
