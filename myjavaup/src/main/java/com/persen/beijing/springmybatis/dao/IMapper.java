package com.persen.beijing.springmybatis.dao;

public interface IMapper<T> {
    public T select(T t);

    public int insert(T t);

    public int update(T t);

    public int delete(T t);
}
