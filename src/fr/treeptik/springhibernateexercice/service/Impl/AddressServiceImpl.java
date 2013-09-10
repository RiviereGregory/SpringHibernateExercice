package fr.treeptik.springhibernateexercice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.springhibernateexercice.dao.AddressDAO;
import fr.treeptik.springhibernateexercice.model.Address;
import fr.treeptik.springhibernateexercice.service.AddressService;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Address, Integer, AddressDAO> implements
		AddressService {

	// On fait l'injection à ce niveau
	@Autowired
	private AddressDAO addressDAO;

	// On retounne l'injection ici pour les méthodes génerique
	@Override
	protected AddressDAO getDao() {

		return addressDAO;
	}

	// @Override
	// @Transactional
	// public Address save(Address address) throws ServiceException {
	// try {
	// address = addressDAO.save(address);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return address;
	// }
	//
	// @Override
	// @Transactional
	// public void remove(Address address) throws ServiceException {
	// try {
	// // On fait cela pour attacher l'objet pour pouvoir l'effacer
	// address = this.findById(address.getId());
	// addressDAO.remove(address);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	//
	// }
	//
	// @Override
	// public Address findById(Integer id) throws ServiceException {
	// try {
	// return addressDAO.findById(id);
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// }
	//
	// @Override
	// public List<Address> findAll() throws ServiceException {
	// List<Address> list;
	// try {
	// list = addressDAO.findAll();
	// } catch (DAOException e) {
	// throw new ServiceException(e.getMessage(), e.getCause());
	// }
	// return list;
	// }

}
