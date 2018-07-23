package frsf.isi.died.tp.modelo.productos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaList;
import frsf.isi.died.tp.modelo.Orden;

public class Taller02Paso05Test {
	
	BibliotecaList biblioteca;
	Libro m1;
	Libro m2;
	Libro m3;
	Libro m4;
	Video m5;
	Video m6;
	Video m7;
	Video m8;
	
	@Before
	public void init() {
		biblioteca=new BibliotecaList();
		m1 = new Libro(1, "Libro 1", 100.0, 1.0, 10, 10, new Date(2017,12,13), Relevancia.ALTA);
		m2 = new Libro(2, "Libro 2", 50.0, 1.0, 10, 20, new Date(2016,12,13), Relevancia.BAJA);
		m3 = new Libro(3, "Libro 3", 150.0, 1.0, 10, 30, new Date(2019,12,13), Relevancia.MEDIA);
		m4 = new Libro(4, "Libro 4", 175.0, 1.0, 10, 50, new Date(2020,12,13), Relevancia.MEDIA);
		m5 = new Video(5, "Video 1", 75.0,1, 12, new Date(2014,12,13), Relevancia.ALTA);
		m6 = new Video(6, "Video 2", 25.0,1, 73, new Date(2019,8,10), Relevancia.BAJA);
		m7 = new Video(7, "Video 3", 275.0,1, 97, new Date(2012,9,5), Relevancia.MEDIA);
		m8 = new Video(8, "Video 4", 145.0,1, 62, new Date(2016,8,16), Relevancia.BAJA);
	}
	
	@Test(expected=RuntimeException.class)
	public void buscarVacio() {
		biblioteca.buscar(10);
	}

	@Test
	public void buscarN1() {
		biblioteca.agregar(m1);
		MaterialCapacitacion encontrado = biblioteca.buscar(100);
		assertTrue(m1== encontrado);
	}

	@Test(expected=RuntimeException.class)
	public void noEncuentraN1() {
		biblioteca.agregar(m2);
		MaterialCapacitacion encontrado = biblioteca.buscar(100);
	}

	@Test
	public void noEncuentraN7() {
		biblioteca.agregar(m1);
		biblioteca.agregar(m2);
		biblioteca.agregar(m3);
		biblioteca.agregar(m4);
		biblioteca.agregar(m5);
		biblioteca.agregar(m6);
		biblioteca.agregar(m7);
		biblioteca.agregar(m8);
		Collection<MaterialCapacitacion> a = biblioteca.buscar("Libro 1", null, null, null);
		ArrayList<MaterialCapacitacion> trie = biblioteca.ordenar(Orden.FECHA);
		System.out.println(trie);
		System.out.println(a);
	}
	
	@Test
	public void buscarN2() {
		biblioteca.agregar(m1);
		biblioteca.agregar(m2);
		MaterialCapacitacion encontrado = biblioteca.buscar(100);
		assertTrue(m1== encontrado);
		encontrado = biblioteca.buscar(50);
		assertTrue(m2== encontrado);
				
	}

	@Test
	public void buscarN3() {
		biblioteca.agregar(m1);
		biblioteca.agregar(m2);
		biblioteca.agregar(m3);
		MaterialCapacitacion encontrado = biblioteca.buscar(50);
		assertTrue(m2== encontrado);
		encontrado = biblioteca.buscar(100);
		assertTrue(m1== encontrado);
		encontrado = biblioteca.buscar(150);
		assertTrue(m3== encontrado);
				
	}

	@Test
	public void buscarN6() {
		biblioteca.agregar(m1);
		biblioteca.agregar(m2);
		biblioteca.agregar(m3);
		biblioteca.agregar(m4);
		biblioteca.agregar(m5);
		biblioteca.agregar(m6);
		MaterialCapacitacion encontrado = biblioteca.buscar(m1.getCosto().intValue());		
		assertTrue(m1== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m2.getCosto().intValue());
		assertTrue(m2== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m3.getCosto().intValue());
		assertTrue(m3== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m4.getCosto().intValue());
		assertTrue(m4== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m5.getCosto().intValue());
		assertTrue(m5== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m6.getCosto().intValue());
		assertTrue(m6== encontrado);				
	}
	
	@Test
	public void buscarN7() {
		biblioteca.agregar(m1);
		biblioteca.agregar(m2);
		biblioteca.agregar(m3);
		biblioteca.agregar(m4);
		biblioteca.agregar(m5);
		biblioteca.agregar(m6);
		biblioteca.agregar(m7);
		MaterialCapacitacion encontrado = biblioteca.buscar(m1.getCosto().intValue());		
		assertTrue(m1== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m2.getCosto().intValue());
		assertTrue(m2== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m3.getCosto().intValue());
		assertTrue(m3== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m4.getCosto().intValue());
		assertTrue(m4== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m5.getCosto().intValue());
		assertTrue(m5== encontrado);

		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m6.getCosto().intValue());
		assertTrue(m6== encontrado);
				
		biblioteca.ordenarPorPrecio(false);
		encontrado = biblioteca.buscar(m7.getCosto().intValue());
		assertTrue(m7== encontrado);
	}

}
