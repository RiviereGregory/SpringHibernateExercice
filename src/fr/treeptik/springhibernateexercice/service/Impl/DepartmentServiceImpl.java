package fr.treeptik.springhibernateexercice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.springhibernateexercice.dao.DepartmentDAO;
import fr.treeptik.springhibernateexercice.model.Department;
import fr.treeptik.springhibernateexercice.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends GenericServiceImpl<Department, Integer, DepartmentDAO>
		implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	protected DepartmentDAO getDao() {
		return departmentDAO;
	}

	// @Override
	// @Transactional
	// public Department save(Department department) throws ServiceException {
	// try {
	// department = departmentDAO.save(department);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return department;
	// }
	//
	// @Override
	// @Transactional
	// public void remove(Department department) throws ServiceException {
	// try {
	// // On fait cela pour attacher l'objet pour pouvoir l'effacer
	// department = this.findById(department.getId());
	// departmentDAO.remove(department);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Department findById(Integer id) throws ServiceException {
	// try {
	// return departmentDAO.findById(id);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public List<Department> findAll() throws ServiceException {
	// List<Department> list;
	// try {
	// list = departmentDAO.findAll();
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return list;
	// }

}
