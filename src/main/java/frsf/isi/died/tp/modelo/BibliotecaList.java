package frsf.isi.died.tp.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
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
}
