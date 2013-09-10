package fr.treeptik.springhibernateexercice.dao;

import java.util.Date;
import java.util.List;

import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.Employee;

public interface EmployeeDAO extends GenericDAO<Employee, Integer> {

	List<Employee> findAllWithProject() throws DAOException;

	List<Employee> findByProjectName(String name) throws DAOException;

	List<Employee> findByStartDate(Date from, Date to) throws DAOException;

	List<Employee> findAllWithoutProject() throws DAOException;

	List<Object[]> findAvgSalaryByDepartment() throws DAOException;

	Employee findLastEmployee() throws DAOException;

	List<Employee> find4LastEmployee() throws DAOException;

}
