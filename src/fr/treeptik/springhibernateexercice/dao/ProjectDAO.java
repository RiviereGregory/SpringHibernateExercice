package fr.treeptik.springhibernateexercice.dao;

import java.util.List;

import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.DesignProject;
import fr.treeptik.springhibernateexercice.model.Project;
import fr.treeptik.springhibernateexercice.model.QualityProject;

public interface ProjectDAO extends GenericDAO<Project, Integer> {

	List<Project> findByDepartmentName(String departmentName) throws DAOException;

	List<QualityProject> findAllQualityProject() throws DAOException;

	List<DesignProject> findAllDesignProject() throws DAOException;
}
