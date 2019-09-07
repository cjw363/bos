package com.itheima.bos.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Classname BaseAction
 * @Description
 * @Date 2019/9/7 12:48
 * @Created by cjw
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    protected T model;

    @Override
    public T getModel() {
        return model;
    }

    public BaseAction(){
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得BaseAction上声明的泛型数组
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        Class<T> entityClass = (Class<T>) actualTypeArguments[0];
        //通过反射创建对象
        try {
            model = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
