package com.persen.beijing.springmybatis;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface IBaseGenericDao<T> {

    /**
     * 保存（持久化）对象
     *
     * @param obj 要持久化的对象
     * @return 执行成功的记录个数
     */
    int save(T obj);

    /**
     * 删除指定的唯一标识符对应的持久化对象
     *
     * @param obj 指定的唯一标识符
     * @return 删除的对象数量
     */
    int delete(T obj);

    /**
     * 更新（持久化）对象
     *
     * @param obj 要持久化的对象
     * @return 执行成功的记录个数
     */
    int update(T obj);

    /**
     * 获取指定的唯一标识符对应的持久化对象
     *
     * @param obj 指定的唯一标识符
     * @return 指定的唯一标识符对应的持久化对象，如果没有对应的持久化对象，则返回null。
     */
    T getEntity(T obj);

    /**
     * 获取查询条件序列
     *
     * @param obj 指j定查询条件
     * @return 返回满足条件的所有对象，如果没有则返回list，其中size()为0
     */
    List<T> getEntities(T obj);

    /**
     * 获取所有记录
     *
     * @return 返回所有对象
     */

    List<T> selectAll();

    /**
     * 获取指定分页记录数
     *
     * @param page
     * @return 指定记录对象
     */
    List<T> selectRows(RowBounds page);

    /**
     * 删除指定的唯一标识符对应的持久化对象
     *
     * @param obj 指定的唯一标识符 用于ta表触发
     * @return 删除的对象数量
     */
    int deleteByIndex(T obj);
}