package application;

import entities.Vendedor;
import model.dao.DAOFactory;
import model.dao.VendedorDAO;

public class Programa {

	public static void main(String[] args) {

		VendedorDAO vendedorDao = DAOFactory.createVendedorDAO();
		
		Vendedor vendedor = vendedorDao.findById(1);

		
		System.out.println(vendedor);
	}

}
