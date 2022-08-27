package application;

import java.util.Date;

import entities.Departamento;
import entities.Vendedor;

public class Programa {

	public static void main(String[] args) {

		Departamento d = new Departamento(1, "Vendas");

		Vendedor v = new Vendedor(1, "Erick", "erickrr98@gmail.com", new Date(), 1900.00, d);

		System.out.println(v);

	}

}
