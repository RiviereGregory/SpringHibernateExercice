package fr.treeptik.springhibernateexercice.service;

import java.util.List;
import java.util.Map;

import fr.treeptik.springhibernateexercice.exception.ServiceException;

public interface GenericService<T, PK, D> {

	T save(T entite) throws ServiceException;

	void remove(T entite) throws ServiceException;

	T findById(PK id) throws ServiceException;

	List<T> findAll() throws ServiceException;

	void removeById(PK id) throws ServiceException;

	List<T> findByMap(Map<String, Object> map) throws ServiceException;

	// Juste pour voir le fonctionnement de Criteria
	List<T> findByMapCriteria() throws ServiceException;

}
