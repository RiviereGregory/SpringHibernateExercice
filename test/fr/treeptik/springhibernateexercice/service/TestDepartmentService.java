package fr.treeptik.springhibernateexercice.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestDepartmentService {
	
	@Autowired
	DepartmentService departmentService;

	@Test
	public void testFindAll() {
		try {
			List<Department> list = departmentService.findAll();

			for (Department department : list) {
				System.out.println("ID : " + department.getId());
				System.out.println("Name : " + department.getName());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}


}
