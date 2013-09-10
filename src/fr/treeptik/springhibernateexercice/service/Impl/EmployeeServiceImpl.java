package fr.treeptik.springhibernateexercice.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.springhibernateexercice.dao.EmployeeDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.Employee;
import fr.treeptik.springhibernateexercice.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Integer, EmployeeDAO>
		implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	protected EmployeeDAO getDao() {
		return employeeDAO;
	}

	// @Override
	// @Transactional
	// public Employee save(Employee employee) throws ServiceException {
	// try {
	// employee = employeeDAO.save(employee);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return employee;
	// }
	//
	// @Override
	// @Transactional
	// public void remove(Employee employee) throws ServiceException {
	// try {
	// // On fait cela pour attacher l'objet pour pouvoir l'effacer
	// employee = this.findById(employee.getId());
	// employeeDAO.remove(employee);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Employee findById(Integer id) throws ServiceException {
	// try {
	// return employeeDAO.findById(id);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public List<Employee> findAll() throws ServiceException {
	// List<Employee> list;
	// try {
	// list = employeeDAO.findAll();
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return list;
	// }

	@Override
	public List<Employee> findAllWithProject() throws ServiceException {
		List<Employee> list;
		try {
			list = employeeDAO.findAllWithProject();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<Employee> findByProjectName(String name) throws ServiceException {
		List<Employee> list;
		try {
			list = employeeDAO.findByProjectName(name);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<Employee> findByStartDate(Date from, Date to) throws ServiceException {
		List<Employee> list;
		try {
			list = employeeDAO.findByStartDate(from, to);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<Employee> findAllWithoutProject() throws ServiceException {
		List<Employee> list;
		try {
			list = employeeDAO.findAllWithoutProject();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public List<Object[]> findAvgSalaryByDepartment() throws ServiceException {
		List<Object[]> list;
		try {
			list = employeeDAO.findAvgSalaryByDepartment();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

	@Override
	public Employee findLastEmployee() throws ServiceException {
		try {
			return employeeDAO.findLastEmployee();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Employee> find4LastEmployee() throws ServiceException {
		List<Employee> list;
		try {
			list = employeeDAO.find4LastEmployee();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return list;
	}

}
