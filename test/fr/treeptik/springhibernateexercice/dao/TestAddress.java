package fr.treeptik.springhibernateexercice.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.dao.AddressDAO;
import fr.treeptik.springhibernateexercice.exception.DAOException;
import fr.treeptik.springhibernateexercice.model.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestAddress {

	@Autowired
	private AddressDAO addressDAO;

	@Test
	public void testFindAll() {
		try {
			List<Address> list = addressDAO.findAll();

			for (Address address : list) {
				System.out.println("ID : " + address.getId());
				System.out.println("City : " + address.getCity());
				System.out.println("State : " + address.getState());
				System.out.println("Street : " + address.getStreet());
				System.out.println("Zip : " + address.getZip());
				System.out.println("");
			}

		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}
}
