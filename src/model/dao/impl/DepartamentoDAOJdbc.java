package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entities.Departamento;
import model.dao.DepartamentoDAO;

public class DepartamentoDAOJdbc implements DepartamentoDAO {

	private Connection conn;

	public DepartamentoDAOJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Departamento dep) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("Insert into departamento(nomeDep) values (?)");
			st.setString(1, dep.getNome());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Departamento dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(""
					+ "delete from departamento "
					+ "where id = ?");
			st.setInt(1, id);
			int linhas = st.executeUpdate();
			if(linhas == 0) {
				System.out.println("Nenhum registro foi apagado");
			}else {
				System.out.println("Registro apagado com sucesso.");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public Departamento findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"select * from departamento where id = ?"
				);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = depInstanciado(rs);
			return dep;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from departamento order by id");

			rs = st.executeQuery();

			List<Departamento> list = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();

			while (rs.next()) {
				Departamento dep = map.get(rs.getInt("id"));
				if (dep == null) {
					dep = depInstanciado(rs);
					map.put(rs.getInt("id"), dep);
				}
				
				list.add(dep);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	private Departamento depInstanciado(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("id"));
		dep.setNome(rs.getString("nomeDep"));
		return dep;
	}



}
