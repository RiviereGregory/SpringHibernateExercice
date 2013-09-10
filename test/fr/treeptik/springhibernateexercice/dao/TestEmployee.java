package fr.treeptik.springhibernateexercice.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestEmployee {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Test
	public void testFindAll() {
		try {
			List<Employee> list = employeeDAO.findAll();
			for (Employee employee : list) {
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());
				// System.out.println("Adresse : " + employee.getAddress().getCity());
				// System.out.println("Departement Nom : " + employee.getDepartment().getName());
				// System.out.println("Manager Nom : " + employee.getManager().getName());
				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
