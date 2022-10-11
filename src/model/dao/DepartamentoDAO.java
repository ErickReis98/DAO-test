package model.dao;

import java.util.List;

import entities.Departamento;

public interface DepartamentoDAO {

	void insert(Departamento dep);

	void update(Departamento dep);

	void deleteById(Integer id);

	Departamento findById(Integer id);

	List<Departamento> findAll();

}
