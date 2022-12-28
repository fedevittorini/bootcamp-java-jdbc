package com.eduit.bootcamp.jdbc.domain;

import java.io.Serializable;
import java.util.Date;

public class Productos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ID_FIELD = "ID";
	public static String DESCRIPTION_FIELD = "Descripcion";
	
	private Integer id;
    private String descripcion;
    private Double precio;
    private Integer cant;
    private Date fechaVencimiento;
    private Integer idCategoria;
    
    public Productos() {
    	
    }
    
	public Productos(Integer id, String descripcion, Double precio, Integer cant, Date fechaVencimiento,
			Integer idCategoria) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cant = cant;
		this.fechaVencimiento = fechaVencimiento;
		this.idCategoria = idCategoria;
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
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Integer getCant() {
		return cant;
	}
	public void setCant(Integer cant) {
		this.cant = cant;
	}
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}	

	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
    
	public String toString() {
		return "id:"+ this.id + " desc:" + this.descripcion;
	}
}
