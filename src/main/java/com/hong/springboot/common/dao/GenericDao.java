package com.hong.springboot.common.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

	void add(T entity);

	List<T> getAll();

	T getById(ID id);

	void delete(T entity);

	void deleteById(ID id);

	void update(T entity);

	void flush();

	T merge(T entity);

	void save(T entity);

	void clear();

}