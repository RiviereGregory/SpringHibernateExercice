package fr.treeptik.springhibernateexercice.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.springhibernateexercice.exception.ServiceException;
import fr.treeptik.springhibernateexercice.model.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/applicationContext.xml" })
public class TestAddressService {
	@Autowired
	AddressService addressService;

	@Test
	public void testFindAll() {
		try {
			List<Address> list = addressService.findAll();

			for (Address address : list) {
				System.out.println("ID : " + address.getId());
				System.out.println("City : " + address.getCity());
				System.out.println("State : " + address.getState());
				System.out.println("Street : " + address.getStreet());
				System.out.println("Zip : " + address.getZip());
				System.out.println("");
			}

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

}
