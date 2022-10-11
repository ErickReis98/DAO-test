package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entities.Departamento;
import entities.Vendedor;
import model.dao.VendedorDAO;

public class VendedorDAOJdbc implements VendedorDAO {

	private Connection conn;

	public VendedorDAOJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor dep) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("Insert into vendedor "
					+ "(nome, email, dataAniversario, salario, idDepartamento) " + "values " + "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, dep.getNome());
			st.setString(2, dep.getEmail());
			st.setDate(3, new java.sql.Date(dep.getDataAniversario().getTime()));
			st.setDouble(4, dep.getSalario());
			st.setInt(5, dep.getDepartamento().getId());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					dep.setId(id);
					DB.closeResultSet(rs);
				}
			} else {
				System.out.println("Erro inesperado, nenhuma linha foi afetada.");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Vendedor dep) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("Update vendedor "
					+ "SET nome = ?, email = ?, dataAniversario = ?, salario = ?, idDepartamento = ? "
					+ "where id = ? ");

			st.setString(1, dep.getNome());
			st.setString(2, dep.getEmail());
			st.setDate(3, new java.sql.Date(dep.getDataAniversario().getTime()));
			st.setDouble(4, dep.getSalario());
			st.setInt(5, dep.getDepartamento().getId());
			st.setInt(6, dep.getId());

			st.executeUpdate();
			System.out.println("Valores atualizados.");

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareCall("delete from vendedor where id = ?");
			st.setInt(1, id);
			
			int linhas = st.executeUpdate();
			
			if(linhas == 0) {
				System.out.println("Nenhuma linha afetada.");
			}else {
				System.out.println("Deletado com sucesso");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("Select vendedor.*, departamento.nomeDep "
					+ "from vendedor inner join departamento on vendedor.idDepartamento = departamento.id "
					+ "where vendedor.id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = depInstanciado(rs);
				Vendedor obj = vendInstanciado(rs, dep);

				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	private Vendedor vendInstanciado(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		obj.setEmail(rs.getString("email"));
		obj.setSalario(rs.getDouble("salario"));
		obj.setDataAniversario(rs.getDate("dataAniversario"));
		obj.setDepartamento(dep);
		return obj;
	}

	private Departamento depInstanciado(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("idDepartamento"));
		dep.setNome(rs.getString("nomeDep"));
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("Select vendedor.*, departamento.nomeDep "
					+ "from vendedor inner join departamento on vendedor.idDepartamento = departamento.id "
					+ "order by nome");

			rs = st.executeQuery();

			List<Vendedor> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();

			while (rs.next()) {
				Departamento dep = map.get(rs.getInt("idDepartamento"));
				if (dep == null) {
					dep = depInstanciado(rs);
					map.put(rs.getInt("idDepartamento"), dep);
				}
				Vendedor obj = vendInstanciado(rs, dep);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("Select vendedor.*, departamento.nomeDep "
					+ "from vendedor inner join departamento on vendedor.idDepartamento = departamento.id "
					+ "where idDepartamento = ? " + "order by nome");

			st.setInt(1, departamento.getId());
			rs = st.executeQuery();

			List<Vendedor> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();

			while (rs.next()) {
				Departamento dep = map.get(rs.getInt("idDepartamento"));

				if (dep == null) {
					dep = depInstanciado(rs);
					map.put(rs.getInt("idDepartamento"), dep);
				}
				Vendedor obj = vendInstanciado(rs, dep);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

}
