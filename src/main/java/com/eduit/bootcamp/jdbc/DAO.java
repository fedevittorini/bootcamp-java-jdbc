package com.eduit.bootcamp.jdbc;

import java.util.List;
import java.util.Map;

public interface DAO<E, K> {

	/**
	 * Devolver los elementos de la entidad {@code E} en forma de lista que coincida con el id {@code theId}.
	 * 
	 * @param theId el id. No puede ser null. 
	 * @return El elementos o null si no encontro nada.
	 */
	E getElementById(final K theId) throws Exception ;
	
	List<E> getElementsByAttributes(final Map<String, Object> theAttributes) throws Exception ;
	
	boolean delete(final E theEntity) throws Exception ;
	
}
