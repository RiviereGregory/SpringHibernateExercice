package fr.treeptik.springhibernateexercice.dao.impl;

import org.springframework.stereotype.Repository;

import fr.treeptik.springhibernateexercice.dao.PhoneDAO;
import fr.treeptik.springhibernateexercice.model.Phone;

@Repository
public class PhoneDAOJPA extends GenericDAOJPA<Phone, Long> implements PhoneDAO {
	public PhoneDAOJPA() {
		super(Phone.class);
	}

}
