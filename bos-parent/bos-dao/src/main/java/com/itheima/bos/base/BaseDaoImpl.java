package com.itheima.bos.base;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

/**
 * @Classname BaseDaoImpl
 * @Description
 * @Date 2019/9/7 12:08
 * @Created by cjw
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

    //代表的是某个实体的类型
    private Class<T> entityClass;

    @Resource//根据类型注入spring工厂中的会话工厂对象sessionFactory
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    public BaseDaoImpl(){
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        entityClass = (Class<T>) actualTypeArguments[0];
    }


    @Override
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    public T findById(Serializable id) {
        return this.getHibernateTemplate().get(entityClass, id);
    }

    public List<T> findAll() {
        String hql = "FROM " + entityClass.getSimpleName();
        return (List<T>) this.getHibernateTemplate().find(hql);
    }

}
