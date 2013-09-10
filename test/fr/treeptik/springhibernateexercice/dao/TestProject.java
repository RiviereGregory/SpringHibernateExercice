package fr.treeptik.springhibernateexercice.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestProject {

	@Autowired
	private ProjectDAO projectDAO;

	@Test
	public void testProjetFindAll() {

		try {
			List<Project> list = projectDAO.findAll();
			System.out.println(list.size());
			
			for (Project project : list) {
				System.out.println("Id " + project.getId());
				System.out.println("Numero " + project.getName());
//				for (Employee employee : project.getEmployees()) {
//					System.out.println("Nom " + employee.getName());
//				}

				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
