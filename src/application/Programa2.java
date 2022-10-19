package application;

import java.util.List;
import java.util.Scanner;

import entities.Departamento;
import model.dao.DAOFactory;
import model.dao.DepartamentoDAO;

public class Programa2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartamentoDAO depDao = DAOFactory.createDepartamentoDAO();

		Departamento departamento = depDao.findById(1);


		List<Departamento> list = depDao.findAll(); 
		for (Departamento obj : list) {
			System.out.println(obj);
			System.out.println("--------------------");
		}
		
		
		System.out.println("============= Teste Insert");
		Departamento novoDep = new Departamento(null, "Lavanderia"); 
		depDao.insert(novoDep);
		System.out.println("Inserido!");
		
		
		System.out.println("============= Teste Update");
		System.out.print("Digite o id do departamento que deseja alterar: ");
		departamento = depDao.findById(sc.nextInt());
		System.out.println("Digite o novo nome do departamento: ");
		departamento.setNome(sc.next());
		depDao.update(departamento);
		
		
		System.out.println("============= Teste Delete");
		System.out.print("Digite o id do departamento que deseja deletar: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		
		
		
		
		
		sc.close();
	}

}
