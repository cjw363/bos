package com.itheima.bos.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname IBaseDao
 * @Description
 * @Date 2019/9/7 12:05
 * @Created by cjw
 */
public interface IBaseDao<T> {
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public T findById(Serializable id);
    public List<T> findAll();

}
