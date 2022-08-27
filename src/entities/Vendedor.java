package entities;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
=======
import java.util.Date;
import java.util.Objects;

public class Vendedor{
>>>>>>> c283f5c8da1c9f122dbc27a4750d8f2f42aa66d6

	private int id;
	private String nome;
	private String email;
	private Date dataAniversario;
	private double salario;
	private Departamento departamento;
	
	public Vendedor(int id, String nome, String email, Date dataAniversario, double salario,
			Departamento departamento) {
<<<<<<< HEAD
=======
		super();
>>>>>>> c283f5c8da1c9f122dbc27a4750d8f2f42aa66d6
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.departamento = departamento;
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
<<<<<<< HEAD
		return Objects.hash(id);
=======
		return Objects.hash(id, nome);
>>>>>>> c283f5c8da1c9f122dbc27a4750d8f2f42aa66d6
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
<<<<<<< HEAD
		return id == other.id;
=======
		return id == other.id && Objects.equals(nome, other.nome);
>>>>>>> c283f5c8da1c9f122dbc27a4750d8f2f42aa66d6
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", dataAniversario=" + dataAniversario
				+ ", salario=" + salario + ", departamento=" + departamento.getName() + "]";
	}
	
	
}
