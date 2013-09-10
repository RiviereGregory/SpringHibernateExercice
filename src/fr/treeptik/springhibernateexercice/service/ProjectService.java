package fr.treeptik.springhibernateexercice.service;

import java.util.List;

import fr.treeptik.springhibernateexercice.dao.ProjectDAO;
import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.DesignProject;
import fr.treeptik.springhibernateexercice.model.Project;
import fr.treeptik.springhibernateexercice.model.QualityProject;

public interface ProjectService extends GenericService<Project, Integer, ProjectDAO> {
	// Project save(Project project) throws ServiceException;
	//
	// void remove(Project project) throws ServiceException;
	//
	// Project findById(Integer id) throws ServiceException;
	//
	// List<Project> findAll() throws ServiceException;

	List<Project> findByDepartmentName(String departmentName) throws ServiceException;

	List<QualityProject> findAllQualityProject() throws ServiceException;

	List<DesignProject> findAllDesignProject() throws ServiceException;
}
