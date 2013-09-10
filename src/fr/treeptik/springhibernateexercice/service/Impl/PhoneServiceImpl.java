package fr.treeptik.springhibernateexercice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.springhibernateexercice.dao.PhoneDAO;
import fr.treeptik.springhibernateexercice.model.Phone;
import fr.treeptik.springhibernateexercice.service.PhoneService;

@Service
public class PhoneServiceImpl extends GenericServiceImpl<Phone, Long, PhoneDAO> implements
		PhoneService {

	@Autowired
	private PhoneDAO phoneDAO;

	@Override
	protected PhoneDAO getDao() {
		return phoneDAO;
	}

	//
	// @Override
	// @Transactional
	// public Phone save(Phone phone) throws ServiceException {
	// try {
	// phone = phoneDAO.save(phone);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return phone;
	// }
	//
	// @Override
	// @Transactional
	// public void remove(Phone phone) throws ServiceException {
	// try {
	// // On fait cela pour attacher l'objet pour pouvoir l'effacer
	// phone = this.findById(phone.getId());
	// phoneDAO.remove(phone);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Phone findById(Long id) throws ServiceException {
	// try {
	// return phoneDAO.findById(id);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public List<Phone> findAll() throws ServiceException {
	// List<Phone> list;
	// try {
	// list = phoneDAO.findAll();
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return list;
	// }
	//

}
