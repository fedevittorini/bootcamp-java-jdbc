package com.eduit.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eduit.bootcamp.jdbc.CategoriaDAOImpl;
import com.eduit.bootcamp.jdbc.ProductoDAOImpl;
import com.eduit.bootcamp.jdbc.domain.Categoria;
import com.eduit.bootcamp.jdbc.domain.Productos;

public class BootcampApp {

	public static void main(String[] arg) throws Exception {
		
		
		Properties prop = PropertiesManager.buildProperties("./src/main/resources/application.properties");
		
		CategoriaDAOImpl catDAO = new CategoriaDAOImpl(prop);
		ProductoDAOImpl prodDAO = new ProductoDAOImpl(prop);
		
		Map<String, Object> descList = new HashMap<String, Object>();
		descList.put("Descripcion", "Resfriado");
		List<Categoria> categories = catDAO.getElementsByAttributes(descList);
		Categoria c = categories.get(0);

		List<Productos> p = prodDAO.getElementByCategoryId(c.getId());
		
		System.out.println(p);
	}
}
