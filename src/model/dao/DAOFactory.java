package model.dao;

import db.DB;
import model.dao.impl.VendedorDAOJdbc;

public class DAOFactory {

	public static VendedorDAO createVendedorDAO() {
		return new VendedorDAOJdbc(DB.getConnetion());
	}
}
