package frsf.isi.died.tp.taller03;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import frsf.isi.died.tp.modelo.Biblioteca;
import frsf.isi.died.tp.modelo.BibliotecaABB;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class TestPaso05 {

	private BibliotecaABB biblioteca;
	private Libro matA;
	private Libro matC;
	private Libro matX;
	private Libro matB;
	private Libro matZ;
	private Libro matK;
	private Video matV;
	private Video matW;
	private Video matN;
	private Video matF;
	private Video matH;
	@Before
	public void init() {
		matA= new Libro(1, "A", 10.0, 20.0, 10);
		matC= new Libro(2, "C", 20.0, 10.0, 10);
		matX= new Libro(3, "X", 30.0, 20.0, 10);
		matB= new Libro(4, "B", 40.0, 30.0, 10);
		matZ= new Libro(5, "Z", 50.0, 25.0, 10);
		matK= new Libro(6, "K", 60.0, 20.0, 10);
		matV= new Video(7, "V", 70.0, 10);
		matW= new Video(8, "W", 80.0, 10);
		matN= new Video(9, "N", 30.0, 10);
		matF= new Video(10, "F", 40.0, 10);
		matH= new Video(11, "H", 50.0, 10);
		biblioteca = new BibliotecaABB();

	}
	
	@Test
	public void testBuscarPorRango() {
		biblioteca.agregar(matX);
		ArrayList<MaterialCapacitacion> prueba1 = (ArrayList) biblioteca.getArbol().rango(0.0, 100.0);
		ArrayList<MaterialCapacitacion> a = new ArrayList<MaterialCapacitacion>();
		a.add(matX);
		assertEquals(prueba1,a);
		biblioteca.agregar(matF);
		ArrayList<MaterialCapacitacion> prueba2 = (ArrayList) biblioteca.getArbol().rango(10.0, 30.0);
		a = new ArrayList<MaterialCapacitacion>();
		assertEquals(prueba2,a);
	}

}
