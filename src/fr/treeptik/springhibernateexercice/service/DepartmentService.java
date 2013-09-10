package fr.treeptik.springhibernateexercice.service;

import fr.treeptik.springhibernateexercice.dao.DepartmentDAO;
import fr.treeptik.springhibernateexercice.model.Department;

public interface DepartmentService extends GenericService<Department, Integer, DepartmentDAO> {
	// Department save(Department department) throws ServiceException;
	//
	// void remove(Department department) throws ServiceException;
	//
	// Department findById(Integer id) throws ServiceException;
	//
	// List<Department> findAll() throws ServiceException;
}
