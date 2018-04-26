/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.util.ArrayList;

import frsf.isi.died.tp.util.Ordenable;

/**
 * Representa de manera abstracta los materiales de capacitación
 * 
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable {
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
	

	/**
	 * Constructor por defecto
	 */
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un Titulo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un costo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id,String titulo, Double costo) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
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

	public boolean equals(Object obj) {
		if (obj instanceof MaterialCapacitacion) {
			return (this.titulo.toLowerCase().equals(((MaterialCapacitacion) obj).getTitulo().toLowerCase()));
		}else return false;
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
