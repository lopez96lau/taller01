/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.util.ArrayList;
import java.util.Date;

import frsf.isi.died.tp.util.Ordenable;

/**
 * Representa de manera abstracta los materiales de capacitación
 * 
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable, Comparable<MaterialCapacitacion> {
	protected Integer id;
	/**
	 * Titulo del material
	 */
	protected String titulo;

	/**
	 * Costo básico que debe sumarse al precio por el mero hecho de publicarlo en el
	 * portal
	 */
	protected Double costo;
	protected Integer calificacion;
	protected Date fechaPublicacion;
	protected Relevancia relevancia;
	
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0,0,null,null);
	}

	/**
	 * Constructor que recibe como argumento un ID y un Titulo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0,0,null,null);
	}

	/**
	 * Constructor que recibe como argumento un ID y un costo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id,String titulo, Double costo, Integer calificacion, Date fechaPublicacion, Relevancia relevancia) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
		this.calificacion = calificacion;
		this.fechaPublicacion = fechaPublicacion;
		this.relevancia = relevancia;
	}

	/**
	 * @integrantes HAUQUE, Federico - LOPEZ, Laureano - ZALAZAR, Ivan
	 * @url https://github.com/lopez96lau/taller01
	 */
	
	
	/**
	 * El precio de un material se define según el tipo del material y toma como
	 * base el costo del mismo
	 * 
	 * @return
	 */
	public abstract Double precio();
	
	public Integer getId() {
		return id;
	}

//	public boolean equals(Object obj) {
//		if (obj instanceof MaterialCapacitacion) {
//			return (this.titulo.toLowerCase().equals(((MaterialCapacitacion) obj).getTitulo().toLowerCase()));
//		}else return false;
//	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialCapacitacion other = (MaterialCapacitacion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public int compareTo(MaterialCapacitacion mat) {
		int comp = this.titulo.compareTo(mat.getTitulo());
		if(comp == 0) {
			comp = this.precio().intValue() - mat.precio().intValue();
		}
		return comp;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getCosto() {
		return costo;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Relevancia getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(Relevancia relevancia) {
		this.relevancia = relevancia;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	
	/**
	 * Retorna verdadero si es una instancia de libro, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esLibro();

	/**
	 * Retorna verdadero si es una instancia de video, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esVideo();
	
	// 02: sobrescribir el metodo toString de la clase "Object"
	//	el método toString retorna un string que representa el material actual
	//  retornando el titulo, y el precio usando el formato : 
	// [Titulo: <titulo> ; Precio: <precio> ]
	
	public String toString() {
		return("[Titulo: "+this.titulo+" ; Precio: "+this.precio()+" ]");
	}
	
	
	
	public final int valor() {
		return (int)this.precio().intValue();
		
		/*
		 * Este metodo funciona porque, gracias a la propiedad del polimorfismo, el método precio
		 * implementado en cada hijo se llama, invocando a la funcion correspondiente de cada instancia no abstracta.
		 */
	}
	
	

}
