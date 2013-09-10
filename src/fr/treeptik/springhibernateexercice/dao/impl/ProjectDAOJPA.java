package fr.treeptik.springhibernateexercice.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.springhibernateexercice.dao.ProjectDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.DesignProject;
import fr.treeptik.springhibernateexercice.model.Project;
import fr.treeptik.springhibernateexercice.model.QualityProject;

@Repository
public class ProjectDAOJPA extends GenericDAOJPA<Project, Integer> implements ProjectDAO {
	public ProjectDAOJPA() {
		super(Project.class);
	}

	@Override
	public List<Project> findByDepartmentName(String departmentName) throws DAOException {
		List<Project> list = null;
		try {
			TypedQuery<Project> query = entityManager
					.createQuery(
							"SELECT DISTINCT pro FROM Project pro JOIN FETCH pro.employees emp JOIN emp.department dept WHERE dept.name=:nameDept",
							Project.class);
			query.setParameter("nameDept", departmentName);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@Override
	public List<QualityProject> findAllQualityProject() throws DAOException {
		List<QualityProject> list = null;
		try {
			TypedQuery<QualityProject> query = entityManager.createQuery(
					"SELECT qp FROM QualityProject qp", QualityProject.class);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@Override
	public List<DesignProject> findAllDesignProject() throws DAOException {
		List<DesignProject> list = null;
		try {
			TypedQuery<DesignProject> query = entityManager.createQuery(
					"SELECT dp FROM DesignProject dp", DesignProject.class);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

}
