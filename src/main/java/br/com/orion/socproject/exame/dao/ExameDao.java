package br.com.orion.socproject.exame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.orion.socproject.exame.model.Exame;
import br.com.orion.socproject.helper.DBConnectHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExameDao {

	
	public boolean save(Exame exame){
		if (null == exame.getId()){
			return insert(exame);
		}
		
		return update(exame);
	}
	
	private boolean insert(Exame exame) {
		int result = 0;
		String sql = "insert into exame (codigo_tuss, nome) values (?,?);";

		try (Connection conn = DBConnectHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, exame.getCodigoTuss());
			stmt.setString(2, exame.getNome());
			result = stmt.executeUpdate();
		} catch (SQLException ex) {
			printLogError(ex);
		}
		return result > 0;
	}
	
	private boolean update(Exame exame) {
		int result = 0;
		String sql = "update exame set codigo_tuss=?, nome=? where id=?";

		try (Connection conn = DBConnectHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setLong(1, exame.getCodigoTuss());
			stmt.setString(2, exame.getNome());
			stmt.setInt(3, exame.getId());
			result = stmt.executeUpdate();
		} catch (SQLException ex) {
			printLogError(ex);
		}
		return result > 0;
	}

	public boolean deleteById(int id) {
		int result = 0;
		String sql = "delete from exame where id=?;";

		try (Connection conn = DBConnectHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException ex) {
			printLogError(ex);
		}
		return result > 0;
	}

	public List<Exame> findAll() {
		List<Exame> list = new ArrayList<>();
		String sql = "select * from exame";

		try (Connection conn = DBConnectHelper.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				Exame exame = new Exame(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list.add(exame);
			}
		} catch (SQLException ex) {
			printLogError(ex);
		}
		return list;
	}

	public Exame getByID(Integer id) {
		String sql = "select * from exame where id=?";
		return retornaExame(id, sql);
	}
	

	public Exame getByCodigoTuss(Integer id) {
		String sql = "select * from exame where codigo_tuss=?";
		return retornaExame(id, sql);
	}

	private Exame retornaExame(Integer id, String sql) {
		Exame exame = null;
		try (Connection conn = DBConnectHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				exame = new Exame(rs.getInt(1), rs.getInt(2), rs.getString(3));
			}
			rs.close();
		} catch (SQLException ex) {
			printLogError(ex);
		}
		return exame;
	}


	private void printLogError(Throwable throwable) {
		log.error(throwable.getMessage(), throwable);
	}

}