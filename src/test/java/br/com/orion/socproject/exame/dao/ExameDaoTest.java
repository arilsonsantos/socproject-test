package br.com.orion.socproject.exame.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.com.orion.socproject.exame.model.Exame;
import br.com.orion.socproject.helper.DBConnectHelper;

public class ExameDaoTest {

	@Test
	public void testConnection() {
		ExameDao exameDao = new ExameDao();
		List<Exame> exames = exameDao.findAll();

		Assert.assertThat(exames.size() >= 0, CoreMatchers.is(Boolean.TRUE));
	}

	@Test
	public void teste2() throws SQLException {

		Connection conn = DBConnectHelper.getConnection();
		conn.close();
		
		Assert.assertThat(conn instanceof  Connection, CoreMatchers.is(Boolean.TRUE));
	}
}
