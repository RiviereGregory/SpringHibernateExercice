package fr.treeptik.springhibernateexercice.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.treeptik.springhibernateexercice.dao.GenericDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;

public class GenericDAOJPA<T, PK> implements GenericDAO<T, PK> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	// Pour obliger a initialiser la variable type car on a pas de constructeur par defaut
	public GenericDAOJPA(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T entite) throws DAOException {
		try {
			entityManager.persist(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return entite;
	}

	@Override
	public void remove(T entite) throws DAOException {
		try {
			entityManager.remove(entite);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public T findById(PK id) throws DAOException {
		try {
			return entityManager.find(type, id);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findAll() throws DAOException {
		try {
			return entityManager.createQuery("SELECT o FROM " + type.getSimpleName() + " o", type)
					.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void removeById(PK id) throws DAOException {
		try {
			Query query = entityManager.createQuery("DELETE FROM " + type.getSimpleName()
					+ "  o WHERE o.id = :id");
			query.setParameter("id", id);
			// Attention il faut penser a l'executer
			query.executeUpdate();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<T> findByMap(Map<String, Object> map) throws DAOException {
		List<T> list = null;
		try {
			Set<String> keySet = map.keySet();

			String valeurDuWhere = null;
			StringBuilder builder = new StringBuilder();
			int premiereValeur = 0;
			for (String key : keySet) {

				if (premiereValeur > 0 && premiereValeur < keySet.size()) {
					System.out.println("Test");
					builder.append(" AND ");
				}

				builder.append(" o.").append(key).append(" = :").append(key);

				premiereValeur++;

			}

			valeurDuWhere = builder.toString();
			System.out.println("");
			System.out.println("Valeur du Where " + valeurDuWhere);
			System.out.println("");
			TypedQuery<T> query = entityManager.createQuery("SELECT o FROM " + type.getSimpleName()
					+ " o " + " WHERE " + valeurDuWhere, type);
			for (String key : keySet) {
				query.setParameter(key, map.get(key));
			}

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		return list;
	}

	// Juste pour voir le fonctionnement de Criteria
	@Override
	public List<T> findByMapCriteria() throws DAOException {
		List<T> list = null;
		try {

			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

			CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);

			Root<T> root = criteriaQuery.from(type);
			// Recherche un nom et un salaire
			// criteriaQuery.select(root).where(
			// criteriaBuilder.equal(root.get("name"), "TestNameBuilder"),
			// criteriaBuilder.equal(root.get("salary"), 50000l));

			// Recherche par ordre inverse du nom
			// criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("name")));

			// Recherche par ordre du nom
			criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("name")));

			TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		return list;
	}
}
