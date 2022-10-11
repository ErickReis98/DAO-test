package entities;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public Departamento(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Departamento() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return "Departamento ID: " + id + "\nNome do departamento: " + nome;
	}

	
	
}
