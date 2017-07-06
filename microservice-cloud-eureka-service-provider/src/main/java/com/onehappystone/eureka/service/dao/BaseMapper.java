package com.onehappystone.eureka.service.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

/**
 * Created by happy on 2017/3/8.
 */
public interface BaseMapper<ID extends Number,T extends Object> {
    /**
     * 添加
     * @param entity
     */
    void insert(T entity) throws DataAccessException;

    /**
     * 根据单个ID删除
     * @param id
     */
    void deleteById(ID id) throws DataAccessException;

    /**
     * 根据多个ID删除
     * @param ids
     */
    void deleteByIds(List<ID> ids) throws DataAccessException;

    /**
     * 修改
     * @param entity
     */
    void update(T entity) throws DataAccessException;

    /**
     * 根据ID查询
     * @param id
     * @return T
     */
    T selectById(ID id) throws DataAccessException;

    /**
     * 根据id查询多个
     * @return
     */
    List<T> selectAll(List<ID> ids) throws DataAccessException;

    /**
     * 查询分页
     * @param t
     * @return
     */
    List<T> selectByPage(T t) throws DataAccessException;
    /**
     * 根据对象属性查询对象
     * @param map
     * @return
     */
    List<T> selectByProperty(Map<String, Object> map) throws DataAccessException;
    /**
     * 根据实体属性查询实体
     * @param t
     * @return
     */
    List<T> selectByEntity(T t) throws DataAccessException;
}
