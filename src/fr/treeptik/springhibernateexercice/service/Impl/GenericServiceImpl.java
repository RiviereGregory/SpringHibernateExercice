package fr.treeptik.springhibernateexercice.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.springhibernateexercice.dao.GenericDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.service.GenericService;

public abstract class GenericServiceImpl<T, PK, D extends GenericDAO<T, PK>> implements
		GenericService<T, PK, D> {

	// Il faut ajouter un type D que l'on fait hériter de GenericDAO
	// Pour l'utiliser on doit faire une méthode Abstraite qui permet de faire l'injection au niveau
	// inférieur et de récupérer le bon DAO

	protected abstract D getDao();

	@Override
	@Transactional
	public T save(T entite) throws ServiceException {
		try {
			entite = getDao().save(entite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return entite;
	}

	@Override
	@Transactional
	public void remove(T entite) throws ServiceException {
		try {

			getDao().remove(entite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public T findById(PK id) throws ServiceException {
		try {
			return getDao().findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws ServiceException {
		List<T> list;
		try {
			list = getDao().findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	@Transactional
	public void removeById(PK id) throws ServiceException {
		try {

			getDao().removeById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

	}

	@Override
	public List<T> findByMap(Map<String, Object> map) throws ServiceException {
		List<T> list;
		try {
			list = getDao().findByMap(map);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	// Juste pour voir le fonctionnement de Criteria
	@Override
	public List<T> findByMapCriteria() throws ServiceException {
		List<T> list;
		try {
			list = getDao().findByMapCriteria();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}
}
