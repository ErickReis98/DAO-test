package application;

import java.util.Date;
import java.util.List;

import entities.Departamento;
import entities.Vendedor;
import model.dao.DAOFactory;
import model.dao.VendedorDAO;

public class Programa {

	public static void main(String[] args) {

		VendedorDAO vendedorDao = DAOFactory.createVendedorDAO();

		Vendedor vendedor = vendedorDao.findById(1);

		System.out.println(vendedor);

		System.out.println();

		Departamento departamento = new Departamento(2, "Lavanderia");
		List<Vendedor> list = vendedorDao.findByDepartamento(departamento);
		for (Vendedor obj : list) {
			System.out.println(obj);
			System.out.println("--------------------");
		}
		
		
		System.out.println("=====================");
		list = vendedorDao.findAll();
		for (Vendedor obj : list) {
			System.out.println(obj);
			System.out.println("--------------------");
		}
		
		
		System.out.println("============= Teste Insert");
		Vendedor novoVendedor = new Vendedor(null, "Alencar", "alencarfilho@terra.com.br", new Date(), 4500.00, departamento); 
		vendedorDao.insert(novoVendedor);
		System.out.println("Inserido! Novo id = "+ novoVendedor.getId());
		
		
		
		
	}

}
