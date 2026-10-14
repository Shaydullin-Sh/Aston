package ru.aston.hw2.dao;

public interface CrudDao<T, ID> {
    void create(T entity);
    T findById(ID id);
    void update(T entity );
    void delete(T entity);
}
