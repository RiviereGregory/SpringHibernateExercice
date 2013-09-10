package fr.treeptik.springhibernateexercice.dao;

import java.util.List;
import java.util.Map;

import fr.treeptik.springhibernateexercice.exception.DAOException;

public interface GenericDAO<T, PK> {

	T save(T entite) throws DAOException;

	void remove(T entite) throws DAOException;

	T findById(PK id) throws DAOException;

	List<T> findAll() throws DAOException;

	void removeById(PK id) throws DAOException;

	List<T> findByMap(Map<String, Object> map) throws DAOException;

	// Juste pour voir le fonctionnement de Criteria
	List<T> findByMapCriteria() throws DAOException;

}
