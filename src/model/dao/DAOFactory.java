package model.dao;

import model.dao.impl.VendedorDAOJdbc;

public class DAOFactory {

	public static VendedorDAO createVendedorDAO() {
		return new VendedorDAOJdbc();
	}
}
