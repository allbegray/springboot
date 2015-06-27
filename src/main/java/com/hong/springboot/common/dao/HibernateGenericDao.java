package com.hong.springboot.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	protected Class<T> entityClass;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HibernateGenericDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		Type type = genericSuperclass.getActualTypeArguments()[0];
		if (type instanceof ParameterizedType) {
			this.entityClass = (Class) ((ParameterizedType) type).getRawType();
		} else {
			this.entityClass = (Class) type;
		}
	}

	@Autowired
	protected SessionFactory sessionFactory;

	public void add(T entity) {
		getCurrentSession().save(entity);
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(entityClass);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getCurrentSession().createCriteria(entityClass).list();
	}

	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		return (T) getCurrentSession().get(entityClass, id);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	public void flush() {
		getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	public T merge(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void save(T entity) {
		getCurrentSession().save(entity);
	}

	public void clear() {
		getCurrentSession().clear();
	}

	public void deleteById(ID id) {
		getCurrentSession().delete(getById(id));
	}

}