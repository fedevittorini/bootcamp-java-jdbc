package com.eduit.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eduit.bootcamp.jdbc.domain.Categoria;

public class CategoriaDAOImpl implements DAO<Categoria, Integer> {

	private Properties propeties;
	
	public CategoriaDAOImpl(final Properties prop) {
		this.propeties = prop;
	}

	public Categoria getElementById(final Integer theId) throws Exception  {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT ID, Descripcion FROM categorias WHERE Id_Categoria=" + theId;
		
		ResultSet rs = statement.executeQuery(sqlProd);
		if (rs.next()) {
			Categoria c = new Categoria(rs.getInt("ID"), rs.getString("Descripcion"));
			return c;
		} else {
			return null;			
		}
			
	}

	public List<Categoria> getElementsByAttributes(Map<String, Object> theAttributes) throws Exception {
		Connection cnx = JDBCManager.getConnection(propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT ID, Descripcion FROM categorias ";
		int i = 0;
		for (Map.Entry<String, Object> entry : theAttributes.entrySet()) {
			if (i == 0) {
				sqlProd = sqlProd + " WHERE ";
			} else {
				sqlProd = sqlProd + " AND ";
			}
			sqlProd = sqlProd + entry.getKey() + "='" + entry.getValue() + "'";
			i++;
		}
		ResultSet rs = statement.executeQuery(sqlProd);
		List<Categoria> output = new ArrayList<Categoria>();
		while (rs.next()) {
			Categoria c = new Categoria(rs.getInt("ID"), rs.getString("Descripcion"));
			output.add(c);
		} 
		return output;
	}

	public boolean delete(Categoria theEntity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
