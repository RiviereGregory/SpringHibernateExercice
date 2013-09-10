package fr.treeptik.springhibernateexercice.service;

import fr.treeptik.springhibernateexercice.dao.PhoneDAO;
import fr.treeptik.springhibernateexercice.model.Phone;

public interface PhoneService extends GenericService<Phone, Long, PhoneDAO> {
	// Phone save(Phone phone) throws ServiceException;
	//
	// void remove(Phone phone) throws ServiceException;
	//
	// Phone findById(Long id) throws ServiceException;
	//
	// List<Phone> findAll() throws ServiceException;
}
