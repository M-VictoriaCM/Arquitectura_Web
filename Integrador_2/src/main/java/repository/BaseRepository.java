package repository;

public interface BaseRepository<T, ID> {
    T save(T entity);
    void delete(T entity);
}
