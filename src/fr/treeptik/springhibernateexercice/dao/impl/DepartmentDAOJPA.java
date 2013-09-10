package fr.treeptik.springhibernateexercice.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.springhibernateexercice.dao.DepartmentDAO;
import fr.treeptik.springhibernateexercice.model.Department;

@Repository
public class DepartmentDAOJPA extends GenericDAOJPA<Department, Integer> implements DepartmentDAO {
	public DepartmentDAOJPA() {
		super(Department.class);
	}

}
