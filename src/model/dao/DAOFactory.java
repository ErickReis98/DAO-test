package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDAOJdbc;
import model.dao.impl.VendedorDAOJdbc;

public class DAOFactory {

	public static VendedorDAO createVendedorDAO() {
		return new VendedorDAOJdbc(DB.getConnetion());
	}
	
	public static DepartamentoDAO createDepartamentoDAO() {
		return new DepartamentoDAOJdbc(DB.getConnetion());
	}
}
