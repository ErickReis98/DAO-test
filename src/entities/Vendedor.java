package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private int id;
	private String nome;
	private String email;
	private Date dataAniversario;
	private double salario;
	private Departamento departamento;

	public Vendedor(int id, String nome, String email, Date dataAniversario, double salario,
			Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.departamento = departamento;
	}

	public Vendedor() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return id == other.id;
	}


	
	
	@Override
	public String toString() {
		return "Vendedor ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nData de Aniversario: " + sdf.format(dataAniversario)
				+ "\nSalario: R$ " + salario + "\nDepartamento: " + departamento.getNome();
	}


}
