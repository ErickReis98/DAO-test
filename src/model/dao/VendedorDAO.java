package model.dao;

import java.util.List;

import entities.Vendedor;

public interface VendedorDAO {

	void insert(Vendedor dep);

	void update(Vendedor dep);

	void deleteById(Integer id);

	Vendedor findById(Integer id);

	
	List<Vendedor> findAll();
}
