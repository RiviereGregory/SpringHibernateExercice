package fr.treeptik.springhibernateexercice.service;

import java.util.Date;
import java.util.List;

import fr.treeptik.springhibernateexercice.dao.EmployeeDAO;
import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.Employee;

public interface EmployeeService extends GenericService<Employee, Integer, EmployeeDAO> {
	// Employee save(Employee employee) throws ServiceException;
	//
	// void remove(Employee employee) throws ServiceException;
	//
	// Employee findById(Integer id) throws ServiceException;
	//
	// List<Employee> findAll() throws ServiceException;

	List<Employee> findAllWithProject() throws ServiceException;

	List<Employee> findByProjectName(String name) throws ServiceException;

	List<Employee> findByStartDate(Date from, Date to) throws ServiceException;

	List<Employee> findAllWithoutProject() throws ServiceException;

	List<Object[]> findAvgSalaryByDepartment() throws ServiceException;

	Employee findLastEmployee() throws ServiceException;

	List<Employee> find4LastEmployee() throws ServiceException;
}
