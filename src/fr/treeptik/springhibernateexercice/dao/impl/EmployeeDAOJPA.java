package fr.treeptik.springhibernateexercice.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.springhibernateexercice.dao.EmployeeDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.Employee;

@Repository
public class EmployeeDAOJPA extends GenericDAOJPA<Employee, Integer> implements EmployeeDAO {

	public EmployeeDAOJPA() {
		super(Employee.class);
	}

	@Override
	public List<Employee> findAllWithProject() throws DAOException {
		try {
			return entityManager.createQuery(
					"SELECT DISTINCT emp FROM Employee emp LEFT JOIN FETCH emp.projects pro",
					Employee.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Employee> findByProjectName(String name) throws DAOException {
		List<Employee> list;
		try {
			TypedQuery<Employee> query = entityManager
					.createQuery(
							"SELECT emp FROM Employee emp LEFT JOIN FETCH emp.projects pro WHERE pro.name= :name",
							Employee.class);
			query.setParameter("name", name);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@Override
	public List<Employee> findByStartDate(Date from, Date to) throws DAOException {
		List<Employee> list;
		try {
			TypedQuery<Employee> query = entityManager
					.createQuery(
							"SELECT emp FROM Employee emp WHERE emp.startDate BETWEEN :dateDebut AND :dateFin",
							Employee.class);
			query.setParameter("dateDebut", from);
			query.setParameter("dateFin", to);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@Override
	public List<Employee> findAllWithoutProject() throws DAOException {
		List<Employee> list = null;
		try {
			// Pour voir si la list est vide on fait IS EMPTY
			TypedQuery<Employee> query = entityManager.createQuery(
					"SELECT emp FROM Employee emp WHERE emp.projects IS EMPTY", Employee.class);

			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAvgSalaryByDepartment() throws DAOException {
		List<Object[]> list = null;
		try {
			Query query = entityManager
					.createQuery("SELECT  dept.id , AVG(emp.salary) FROM Department dept JOIN "
							+ " dept.employees emp GROUP BY dept.id ");
			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}

	@Override
	public Employee findLastEmployee() throws DAOException {
		Employee employee;
		try {
			TypedQuery<Employee> query = entityManager.createQuery(
					"SELECT  emp FROM Employee emp WHERE emp.startDate = "
							+ " (SELECT MAX(e.startDate) FROM Employee e) ", Employee.class);
			query.setMaxResults(1);
			employee = query.getSingleResult();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return employee;
	}

	@Override
	public List<Employee> find4LastEmployee() throws DAOException {
		List<Employee> list = null;
		try {
			TypedQuery<Employee> query = entityManager.createQuery(
					"SELECT emp FROM Employee emp ORDER BY emp.startDate DESC", Employee.class);

			query.setMaxResults(4);
			list = query.getResultList();

		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return list;
	}
}
