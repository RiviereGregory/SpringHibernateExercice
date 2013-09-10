package fr.treeptik.springhibernateexercice.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.springhibernateexercice.dao.ProjectDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.DesignProject;
import fr.treeptik.springhibernateexercice.model.Project;
import fr.treeptik.springhibernateexercice.model.QualityProject;
import fr.treeptik.springhibernateexercice.service.ProjectService;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Integer, ProjectDAO> implements
		ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	protected ProjectDAO getDao() {
		return projectDAO;
	}

	// @Override
	// @Transactional
	// public Project save(Project project) throws ServiceException {
	// try {
	// project = projectDAO.save(project);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return project;
	// }
	//
	// @Override
	// @Transactional
	// public void remove(Project project) throws ServiceException {
	// try {
	// project = this.findById(project.getId());
	// projectDAO.remove(project);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Project findById(Integer id) throws ServiceException {
	// try {
	// return projectDAO.findById(id);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public List<Project> findAll() throws ServiceException {
	// List<Project> list;
	// try {
	// list = projectDAO.findAll();
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return list;
	//
	// }

	@Override
	public List<Project> findByDepartmentName(String departmentName) throws ServiceException {
		List<Project> list;
		try {
			list = projectDAO.findByDepartmentName(departmentName);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<QualityProject> findAllQualityProject() throws ServiceException {
		List<QualityProject> list;
		try {
			list = projectDAO.findAllQualityProject();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<DesignProject> findAllDesignProject() throws ServiceException {
		List<DesignProject> list;
		try {
			list = projectDAO.findAllDesignProject();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

}
