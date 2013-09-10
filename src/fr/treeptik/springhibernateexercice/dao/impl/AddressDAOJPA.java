package fr.treeptik.springhibernateexercice.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.springhibernateexercice.dao.AddressDAO;
import fr.treeptik.springhibernateexercice.model.Address;

@Repository
public class AddressDAOJPA extends GenericDAOJPA<Address, Integer> implements AddressDAO {

	public AddressDAOJPA() {
		super(Address.class);
	}

}
