package com.eduit.bootcamp.jdbc.domain;

import java.io.Serializable;

public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String descripcion;
	
	public Categoria() {
	}

	public Categoria(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return "id:"+ this.id + " desc:" + this.descripcion;
	}
	
}
