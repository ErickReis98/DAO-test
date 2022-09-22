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

		Departamento departamento = new Departamento(1, "Lavanderia");
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
		Vendedor novoVendedor = new Vendedor(null, "Rute Rodrigues da Silva", "ag65rr71@gmail.com", new Date(), 100.00, departamento); 
		vendedorDao.insert(novoVendedor);
		System.out.println("Inserido! Novo id = "+ novoVendedor.getId());
		
		
		System.out.println("============= Teste Vendedor");
		vendedor = vendedorDao.findById(5);
		vendedor.setNome("Alencar Gomes dos Reis Filho");
		vendedorDao.update(vendedor);
		
	}

}
