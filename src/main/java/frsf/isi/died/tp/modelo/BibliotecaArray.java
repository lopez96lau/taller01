package frsf.isi.died.tp.modelo;

import java.util.Arrays;
import java.util.Collection;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.util.ListaServiceRadix;
import frsf.isi.died.tp.util.ListasService;


/**
 * Esta clase implementa la interface Biblioteca y todas sus operaciones, gestionando todos los
 * @see MaterialCapacitacion en un arreglo.
 * @author mdominguez
 *
 */
public class BibliotecaArray implements Biblioteca{

	private ListasService servicio;
	
	/**
	 * Arreglo donde se almacenan todos los materiales de capacitacion
	 */
	private MaterialCapacitacion[] materialCapacitacion;
	/**
	 * Variable interna de control que se utiliza para llevar registro de cuantos materiales 
	 * se llevan insertados. Se utiliza para evitar insertar un nuevo material fuera de rango
	 * y tambien para responder la consulta acerca de cuantos materiales hay insertados
	 */
	private Integer cantidadMaterial;
	
	// 12: crear una variable de tipo ListaService que apuntará a una instancia del servicio de operaciones de lista

	
	public BibliotecaArray() {
		cantidadMaterial=0;
		this.materialCapacitacion= new MaterialCapacitacion[5];
		//  13: inicializar la variable de tipo ListaService para que apunte el servicio de operaciones de listas		
		servicio = new ListaServiceRadix(materialCapacitacion);
	}

	@Override
	public void agregar(MaterialCapacitacion material) {
		// 06: se agrega un material al arreglo de materiales de capacitacion si hay espacio en el arreglo
		// caso contrario el metodo no agrega ningun elemento y termina su ejecución
		
		if ( cantidadMaterial < 5) {
			this.materialCapacitacion[cantidadMaterial] = material;
			cantidadMaterial++;
		}
		
	}

	@Override
	public Integer cantidadMateriales() {
		// 07: retorna la cantidad de materiales que hay ingresados en el sistema
		
		int j = 0;
		while(this.materialCapacitacion[j] != null) j++;
		return j;
	}


	@Override
	public Integer cantidadLibros() {
		// 08: retorna la cantidad de libros registrados en el sistema.
		// No se puede usar para este método el operador "instanceOf" ni realizar ningun tipo de casting. 
		
		int k = 0;
		for(int aux = 0 ; aux < 5 ; aux++) {
			if(this.materialCapacitacion[aux] != null && this.materialCapacitacion[aux].esLibro()) k++;
		}
		return k;
	}


	@Override
	public Integer cantidadVideos() {
		// 09: retorna la cantidad de videos registrados en el sistema. 
		// No se puede usar para este método el operador "instanceOf" ni realizar ningun tipo de casting. 
		int k = 0;
		
		for(int aux = 0 ; aux < 5 ; aux++) {
			if(this.materialCapacitacion[aux] != null && this.materialCapacitacion[aux].esVideo()) k++;
		}
		
		return k;
	}

	@Override
	public void imprimir() {		
		//14: invocar al método imprimir de la variable de tipo ListaService para que imprima el arreglo 
		servicio.imprimir();
	}
		

	@Override
	public void ordenarPorPrecio(Boolean b) {
		// 15: invocar al metodo ordenar de la variable de tipo ListaService para que ordene el arreglo
		servicio.ordenar();
	}


	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return Arrays.asList(this.materialCapacitacion);
	}

	@Override
	public MaterialCapacitacion buscar(Integer precio) {
		return null;
	}


}
