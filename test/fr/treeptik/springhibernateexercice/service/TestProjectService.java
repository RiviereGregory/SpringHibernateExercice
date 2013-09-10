package fr.treeptik.springhibernateexercice.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.DesignProject;
import fr.treeptik.springhibernateexercice.model.Employee;
import fr.treeptik.springhibernateexercice.model.Project;
import fr.treeptik.springhibernateexercice.model.QualityProject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestProjectService {

	@Autowired
	private ProjectService projectService;

	@Test
	public void testFindAllDesignProject() {
		try {
			System.out.println("*********** Find All Design Project *************");
			List<DesignProject> list = projectService.findAllDesignProject();
			for (Project project : list) {
				System.out.println("Id : " + project.getId());
				System.out.println("Nom : " + project.getName());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAllQualityProject() {
		try {
			System.out.println("*********** Find All Quality Project *************");
			List<QualityProject> list = projectService.findAllQualityProject();
			for (Project project : list) {
				System.out.println("Id : " + project.getId());
				System.out.println("Nom : " + project.getName());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindByDepartmentName() {
		try {
			System.out.println("*********** Find By Department Name *************");
			List<Project> list = projectService.findByDepartmentName("QA");
			for (Project project : list) {
				System.out.println("Id : " + project.getId());
				System.out.println("Nom : " + project.getName());
				for (Employee employee : project.getEmployees()) {
					System.out.println("Nom Employee : " + employee.getName());
				}
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAll() {
		try {
			List<Project> list = projectService.findAll();
			for (Project project : list) {
				System.out.println("Id : " + project.getId());
				System.out.println("Nom : " + project.getName());
				// for (Employee employee : project.getEmployees()) {
				// System.out.println("Nom Employee : " + employee.getName());
				// }
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

}
