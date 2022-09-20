package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Vendedor dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

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
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("idDepartamento"));
				dep.setName(rs.getString("nomeDep"));
				Vendedor obj = new Vendedor();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setEmail(rs.getString("email"));
				obj.setSalario(rs.getDouble("salario"));
				obj.setDataAniversario(rs.getDate("dataAniversario"));
				obj.setDepartamento(dep);
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

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
