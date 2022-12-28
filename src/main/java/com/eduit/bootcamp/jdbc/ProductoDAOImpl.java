package com.eduit.bootcamp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eduit.bootcamp.jdbc.domain.Productos;

public class ProductoDAOImpl implements DAO<Productos, Integer> {

	private Properties propeties;
	
	public ProductoDAOImpl(final Properties prop) {
		this.propeties = prop;
	}

	public Productos getElementById(final Integer theId) throws Exception  {
		Connection cnx = JDBCManager.getConnection(this.propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT ID, Descripcion, Precio, Cant, FechaVencimiento, Id_Categoria FROM productos WHERE ID=" + theId;
		
		ResultSet rs = statement.executeQuery(sqlProd);
		if (rs.next()) {
			Productos c = new Productos(rs.getInt("ID"),
					rs.getString("Descripcion"), 
					rs.getDouble("Precio"),
					rs.getInt("Cant"),
					rs.getDate("FechaVencimiento"), 
					rs.getInt("Id_Categoria"));
			return c;
		} else {
			return null;			
		}
			
	}
	
	public List<Productos> getElementByCategoryId(final Integer theId) throws Exception  {
		Connection cnx = JDBCManager.getConnection(this.propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT ID, Descripcion, Precio, Cant, FechaVencimiento, Id_Categoria FROM productos WHERE Id_Categoria=" + theId;
		
		ResultSet rs = statement.executeQuery(sqlProd);
		List<Productos> output = new ArrayList<Productos>();
		while (rs.next()) {
			Productos p = new Productos(rs.getInt("ID"),
					rs.getString("Descripcion"), 
					rs.getDouble("Precio"),
					rs.getInt("Cant"),
					rs.getDate("FechaVencimiento"), 
					rs.getInt("Id_Categoria"));
			output.add(p);
		} 
		return output;
			
	}

	public List<Productos> getElementsByAttributes(Map<String, Object> theAttributes) throws Exception {
		Connection cnx = JDBCManager.getConnection(this.propeties);
		Statement statement = cnx.createStatement();
		
		String sqlProd = "SELECT ID, Descripcion, Precio, Cant, FechaVencimiento, Id_Categoria FROM productos ";
		int i = 0;
		for (Map.Entry<String, Object> entry : theAttributes.entrySet()) {
			if (i == 0) {
				sqlProd = sqlProd + " WHERE ";
			} else {
				sqlProd = sqlProd + " AND ";
			}
			sqlProd = sqlProd + entry.getKey() + "=" + entry.getValue() + "";
			i++;
		}
		ResultSet rs = statement.executeQuery(sqlProd);
		List<Productos> output = new ArrayList<Productos>();
		while (rs.next()) {
			Productos p = new Productos(rs.getInt("ID"),
					rs.getString("Descripcion"), 
					rs.getDouble("Precio"),
					rs.getInt("Cant"),
					rs.getDate("FechaVencimiento"), 
					rs.getInt("Id_Categoria"));
			output.add(p);
		} 
		return output;
	}

	public boolean delete(Productos theEntity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
