package repository;

import java.util.List;

public interface BaseRepository<T, ID> {
    T save(T entity);
    void delete(T entity);
    T findById(ID id);
    List<T> findAll();
    void insert(T entity);
}
