/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.tp.modelo.productos;

import java.util.Date;
import java.util.Objects;

/**
 * Representa un libro en el sistema de biblioteca digital
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion {
	/**
	 * Precio al que el libro se compro a la editorial que lo vende
	 */
	private Double precioCompra;
	/**
	 * Cantidad de paginas del libro
	 */
	private Integer paginas;

	/**
	 * Constructor por defecto del Libro
	 */
	public Libro() {
	}

	/**
	 * permite crerar un libro solo con su titulo e identificador
	 * @param id es el identificador del libro
	 * @param titulo es el titulo del libro
	 */
	public Libro(Integer id, String titulo) {
		this(id, titulo,0.0,0.0,0,0,null,null);
	}

	/**
	 * permite crear un libro con todos sus parametros
	 * @param id es el identificador del libro
	 * @param titulo es el titulo del libro
	 * @param costo es el costo de ofrecerlo online
	 * @param precioCompra es el precio al que se adquirió el libro a la editorial
	 * @param paginas cantidad de paginas del libro
	 */
	public Libro(Integer id, String titulo, Double costo, Double precioCompra, Integer paginas, Integer calificacion, Date fechaPublicacion, Relevancia relevancia) {
		super(id, titulo, costo, calificacion, fechaPublicacion, relevancia);
		this.precioCompra = precioCompra;
		this.paginas = paginas;
	}
	

	/**
	 * retorna el precio al que el libro fue comprado
	 * @return precio al que el libro fue comprado
	 */
	public Double getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * asigna el precio de compra del libro
	 * @param precioCompra
	 */
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	/**
	 * retorna la cantidad de paginas del libro
	 * @return cantidad de paginas
	 */
	public Integer getPaginas() {
		return paginas;
	}

	/**
	 * asigna la cantidad de paginas del libro
	 * @param paginas
	 */
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public Boolean esLibro() {
		return true;
	}

	@Override
	public Boolean esVideo() {
		return false;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Libro) {
			return (this.titulo.toLowerCase().equals(((Libro) obj).getTitulo().toLowerCase()));
		}else return false;
	}

	/**
	 * El precio de un libro se calcula segun la siguiente formula
	 * PRECIO = costo + (precio de compra * FACTOR_PAGINAS)
	 * FACTOR_PAGINAS es un 3% cada 150 paginas.
	 * 
	 * Por ejemplo, para un libro cuyo costo de publicacion es de $50 y cuyo precio de compra
	 * es de $100 si tiene 460 paginas se calculará su precio final como
	 * 
	 * PRECIO = 50.0 + (100.0 * (1.0+ (0.03 * 460/150))); 
	 * PRECIO = 50.0 + (100.0 * (1.0 + 0.09)) = 50.0 + 109.0 = 159.0
	 */
	@Override
	public Double precio() {
		
		int cantFactores = this.paginas/150;
		double factor_paginas = ((cantFactores*0.03)+1.0);
		Double precio = this.costo + (this.precioCompra * factor_paginas);

		return precio;
	}

	

}