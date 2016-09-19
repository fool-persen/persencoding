package com.persen.beijing.mybatis.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseGenericDAO<T, ID extends Serializable> {

    /**
     * 保存（持久化）对象
     *
     * @param o 要持久化的对象
     * @return 执行成功的记录个数
     */
    public Integer save(T ob);

    /**
     * 更新（持久化）对象
     *
     * @param o 要持久化的对象
     * @return 执行成功的记录个数
     */
    public Integer update(T ob);

    /**
     * 获取指定的唯一标识符对应的持久化对象
     *
     * @param id 指定的唯一标识符
     * @return 指定的唯一标识符对应的持久化对象，如果没有对应的持久化对象，则返回null。
     */
    public T getById(String id);

    public T getById(Long id);

    /**
     * 删除指定的唯一标识符对应的持久化对象
     *
     * @param id 指定的唯一标识符
     * @return 删除的对象数量
     */
    public Integer deleteById(ID id);

    /**
     * 删除指定的唯一标识符数组对应的持久化对象
     *
     * @param ids 指定的唯一标识符数组
     * @return 删除的对象数量
     */
    public Integer deleteByIds(ID[] ids);

    /**
     * 获取满足查询参数条件的数据总数
     *
     * @param param 查询参数
     * @return 数据总数
     */
    public Integer getCountBy(T param);

    /**
     * 不分页查询
     *
     * @param param 查询参数
     * @param sort  排序字段名
     * @param dir   排序方式（升序(asc)或降序(desc)
     * @return 查询结果列表
     */
    public List<T> findListBy(T param, String sort, String dir);

}