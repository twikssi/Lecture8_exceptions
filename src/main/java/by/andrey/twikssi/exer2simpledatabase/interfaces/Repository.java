package by.andrey.twikssi.exer2simpledatabase.interfaces;

import by.andrey.twikssi.exer2simpledatabase.exceptions.ItemNotFoundException;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findById(String id) throws ItemNotFoundException;
    void save(T item);
    void delete(String id) throws ItemNotFoundException;
}
