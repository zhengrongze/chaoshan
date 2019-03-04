package com.mc.service.impl;

import com.mc.MyMapper;
import com.mc.service.BaseService;
import com.sun.xml.internal.rngom.parse.host.Base;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName BaseServiceImpl
 * @Author ZhengRongZe
 * @Date 2018/7/29 9:59
 **/
public  class BaseServiceImpl<T> implements BaseService<T> {

    private MyMapper myMapper;

    public void setMyMapper(MyMapper myMapper) {
        this.myMapper = myMapper;
    }

    @Override
    public void save(T eniity) {
        myMapper.insert(eniity);
    }

    @Override
    public void delete(T entity) {
        myMapper.delete(entity);
    }

    @Override
    public void update(T entity) {
        myMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public T findById(Integer id) {
        return (T) myMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> getAll() {
        return myMapper.selectAll();
    }
}
