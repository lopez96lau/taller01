/**
 * 
 */
package frsf.isi.died.tp.modelo.productos;

import java.lang.Object.*;
import java.util.Date;

/**
 * @author laureano
 *
 */
public class Video extends MaterialCapacitacion {
	
	private static final Double costoDuracion = 0.15;
	private Integer duracion;
	
	/* (non-Javadoc)
	 * @see frsf.isi.died.tp.modelo.productos.MaterialCapacitacion#precio()
	 */
	@Override
	public Double precio() {
		Double precio = this.costo + this.costoDuracion * this.duracion;
		return precio;
	}

	/* (non-Javadoc)
	 * @see frsf.isi.died.tp.modelo.productos.MaterialCapacitacion#esLibro()
	 */
	@Override
	public Boolean esLibro() {
		return false;
	}

	/* (non-Javadoc)
	 * @see frsf.isi.died.tp.modelo.productos.MaterialCapacitacion#esVideo()
	 */
	@Override
	public Boolean esVideo() {
		return true;
	}
	
	public Video() {
		
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Video) {
			return (this.titulo.toLowerCase().equals(((Video) obj).getTitulo().toLowerCase()));
		}else return false;
	}
	
	public Video(Integer id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	public Video(Integer id, String titulo, Double costo, Integer calificacion, Date fechaPublicacion, Relevancia relevancia) {
		super(id, titulo, costo, calificacion, fechaPublicacion, relevancia);
	}
	
	public Video(Integer id, String titulo, Double costo, Integer duracion, Integer calificacion, Date fechaPublicacion, Relevancia relevancia) {
		super(id, titulo, costo, calificacion, fechaPublicacion, relevancia);
		this.duracion = duracion;
	}
	

}
