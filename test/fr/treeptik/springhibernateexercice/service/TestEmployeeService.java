package fr.treeptik.springhibernateexercice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.springhibernateexercice.builder.EmployeeBuilder;
import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.Employee;
import fr.treeptik.springhibernateexercice.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestEmployeeService {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testFindByCriteria() {
		try {
			System.out.println("********* Find By Criteria *********");

			List<Employee> list = employeeService.findByMapCriteria();
			for (Employee employee : list) {
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());
				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindByMap() {
		try {
			System.out.println("********* Find By Map *********");
			Map<String, Object> map = new HashMap<>();
			map.put("name", "TestNameBuilder");
			map.put("salary", 50000l);

			List<Employee> list = employeeService.findByMap(map);
			for (Employee employee : list) {
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());
				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFind4LastEmployee() {
		try {
			System.out.println("********* Find 4 Last Employee *********");
			List<Employee> list = employeeService.find4LastEmployee();
			for (Employee employee : list) {
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());
				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindLastEmployee() {
		try {
			System.out.println("********* Find Last Employee() *********");
			Employee employee = employeeService.findLastEmployee();

			System.out.println("Id : " + employee.getId());
			System.out.println("Nom : " + employee.getName());

			System.out.println("Salaire : " + employee.getSalary());
			System.out.println("Date de début : " + employee.getStartDate());
			System.out.println("");

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAll() {
		try {
			System.out.println("********* Find All *********");
			List<Employee> list = employeeService.findAll();
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

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAllWithProject() {
		try {
			System.out.println("********* Find All with project*********");
			List<Employee> list = employeeService.findAllWithProject();
			for (Employee employee : list) {
				// System.out.println("EMP : " + employee);
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());

				System.out.println("Nombre de project : " + employee.getProjects().size());
				for (Project project : employee.getProjects()) {
					System.out.println("Nom de project : " + project.getName());
				}

				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAllWithoutProject() {
		try {
			System.out.println("********* Find All with project*********");
			List<Employee> list = employeeService.findAllWithoutProject();
			for (Employee employee : list) {
				// System.out.println("EMP : " + employee);
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());

				// System.out.println("Nombre de project : " + employee.getProjects().size());

				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindAvgSalaryByDepartment() {
		try {
			System.out.println("********* Find Avg Salary By Department*********");
			List<Object[]> list = employeeService.findAvgSalaryByDepartment();
			for (Object[] employee : list) {
				System.out.println("Id dept: " + employee[0]);
				// System.out.println("Id Empl: " + employee[1]);
				System.out.println("moyenne salaire: " + employee[1]);

				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindByProjectName() {
		try {
			System.out.println("********* Find By Project Name*********");
			List<Employee> list = employeeService.findByProjectName("Design Release2");
			for (Employee employee : list) {
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());
				for (Project project : employee.getProjects()) {
					System.out.println("Nom de project : " + project.getName());
				}
				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testFindByStartDate() {
		try {
			System.out.println("********* Find By Start Date*********");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateDebut = dateFormat.parse("26/03/2002");
			Date dateFin = dateFormat.parse("22/07/2013");

			List<Employee> list = employeeService.findByStartDate(dateDebut, dateFin);
			for (Employee employee : list) {
				System.out.println("Id : " + employee.getId());
				System.out.println("Nom : " + employee.getName());
				System.out.println("Salaire : " + employee.getSalary());
				System.out.println("Date de début : " + employee.getStartDate());
				System.out.println("");
			}

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	@Transactional
	public void TestRemoveById() {
		try {
			System.out.println("******* test remove by id ********");

			employeeService.removeById(17);

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	// Pour que la transaction soit rollBacker
	@Transactional
	public void testSave() {
		try {
			System.out.println("******* test save ********");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			// Employee employee = new Employee(null, "TestName2", 10000l,
			// dateFormat.parse("10/01/2013"), null, null, null);

			// Utilisation du Builder pour Employee
			Employee employee = new EmployeeBuilder().withName("TestNameBuilder")
					.withSalary(40000l).withStartDate(dateFormat.parse("21/05/2013")).build();

			employee = employeeService.save(employee);
			System.out.println("Id : " + employee.getId());
			System.out.println("Nom : " + employee.getName());
			System.out.println("Salaire : " + employee.getSalary());
			System.out.println("Date de début : " + dateFormat.format(employee.getStartDate()));
			System.out.println("");

		} catch (ServiceException | ParseException e) {
			Assert.fail(e.getMessage());
		}

	}
}
