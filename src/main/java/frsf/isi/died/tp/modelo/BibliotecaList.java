package frsf.isi.died.tp.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Relevancia;
import frsf.isi.died.tp.modelo.productos.Video;
import frsf.isi.died.tp.util.MaterialNoEncontradoException;

public class BibliotecaList implements Biblioteca {

	private ArrayList<MaterialCapacitacion> materiales;
	
	public BibliotecaList() {
		this.materiales = new ArrayList<>();
	}
	
	@Override
	public void agregar(MaterialCapacitacion material) {
		this.materiales.add(material);
	}

	@Override
	public Integer cantidadMateriales() {
		return new Integer (this.materiales.size());
	}

	@Override
	public Integer cantidadLibros() {
		int i = 0;
		for(MaterialCapacitacion mat : materiales) {
			if(mat != null && mat instanceof Libro ) {
				i++;
			}
		}
		return new Integer(i);
	}

	@Override
	public Integer cantidadVideos() {
		int i = 0;
		for(MaterialCapacitacion mat : materiales) {
			if(mat != null && mat instanceof Video ) {
				i++;
			}
		}
		return new Integer(i);
	}

	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return this.materiales;
	}

	@Override
	public void imprimir() {
		for(MaterialCapacitacion mat: materiales) {
			System.out.println(mat.toString());
		}
	}

	@Override
	public void ordenarPorPrecio(Boolean b) {
		if (b) {
			Collections.sort(this.materiales, (m1, m2) -> m1.precio().intValue() - m2.precio().intValue());
		}else {
			Collections.sort(this.materiales);
		}

	}
	@Override
	public MaterialCapacitacion buscar(Integer precio) throws MaterialNoEncontradoException {
		Collections.sort(this.materiales, (m1, m2) ->  m1.getCosto().intValue() - m2.getCosto().intValue());
		return buscadorBinario (0, this.materiales.size()-1, precio);
		}

	private MaterialCapacitacion buscadorBinario(Integer i,Integer f, Integer c) throws MaterialNoEncontradoException{
		int centro = (i+f)/2;
		if (i==f) {
			if(this.materiales.get(i).getCosto().intValue() == c.intValue()) {
				return this.materiales.get(i);
			}else {
				throw new MaterialNoEncontradoException();
			}
		}else if (this.materiales.get(centro).getCosto().intValue() == c.intValue()){
			return this.materiales.get(centro);
		}else if (this.materiales.get(centro).getCosto().intValue() > c.intValue()) {
			return buscadorBinario(i, centro-1, c);
		}else {
			return buscadorBinario(centro+1, f, c);
		}
	}
	
	//BUSQUEDA POR TITULO, CALIFICACION Y FECHA ---------- LO DEL TEMA NO ESTA EN NINGUN LADO
	
	public ArrayList<MaterialCapacitacion> buscar (String titulo, Integer calificacion, Date fechaDesde, Date fechaHasta){
		ArrayList<MaterialCapacitacion> mats = (ArrayList<MaterialCapacitacion>)(this.materiales.clone());
		if (titulo != null )
			mats.removeIf(e -> (!e.getTitulo().equals(titulo)));
		if (calificacion != null) {
			mats.removeIf(e -> (!e.getCalificacion().equals(calificacion)));
		}
		if(fechaDesde != null) {
			mats.removeIf(e -> (e.getFechaPublicacion().before(fechaDesde)));
		}
		if(fechaHasta != null) {
			mats.removeIf(e -> (e.getFechaPublicacion().after(fechaHasta)));
		}
		return mats;
	}
	
	// TODO ORDENAMIENTO DE LA LISTA.
	public ArrayList<MaterialCapacitacion> ordenar (Orden ord){
		ArrayList<MaterialCapacitacion> mats = (ArrayList<MaterialCapacitacion>)(this.materiales.clone());
		switch(ord) {
			case ALFABETICO: Collections.sort(mats, (a, b) -> a.getTitulo().compareToIgnoreCase(b.getTitulo())); break;
			case PRECIO: Collections.sort(mats, (a, b) -> a.precio() < b.precio() ? -1 : a.precio() == b.precio() ? 0 : 1); break;
			case CALIFICACION: Collections.sort(mats, (a, b) -> a.getCalificacion() < b.getCalificacion() ? -1 : a.getCalificacion() == b.getCalificacion() ? 0 : 1); break;
			case FECHA: Collections.sort(mats, (a, b) -> a.getFechaPublicacion().before(b.getFechaPublicacion()) ? -1 : a.getFechaPublicacion().equals(b.getFechaPublicacion()) ? 0 : 1); break;
			case REELEVANCIA: Collections.sort(mats, (a, b) -> a.getRelevancia().equals(b.getRelevancia()) ? 0 : a.getRelevancia() == Relevancia.ALTA ? 1 : b.getRelevancia() == Relevancia.ALTA ? -1 : a.getRelevancia() == Relevancia.BAJA ? -1 : 1); break;
		}
		return mats;
	}
}
