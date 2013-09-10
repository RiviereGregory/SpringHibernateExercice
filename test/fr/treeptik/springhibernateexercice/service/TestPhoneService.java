package fr.treeptik.springhibernateexercice.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.Phone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestPhoneService {

	@Autowired
	private PhoneService phoneService;

	@Test
	public void testFindAll() {
		try {
			List<Phone> list = phoneService.findAll();
			for (Phone phone : list) {
				System.out.println("Id : " + phone.getId());
				System.out.println("Nom : " + phone.getEmployee().getName());
				System.out.println("Type : " + phone.getType());
				System.out.println("Numero : " + phone.getNumber());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

}
