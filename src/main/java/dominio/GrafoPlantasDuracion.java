/**
 * 
 */
package dominio;

import java.util.ArrayList;
import java.util.LinkedList;

import dominio.utils.Dijkstra;
import estructuras.Grafo;
import estructuras.Vertice;
import gestor.GestorPlanta;
import gestor.GestorRuta;

/**
 * @author esteb
 *
 */
public class GrafoPlantasDuracion extends Grafo<Planta>{
	
	private GestorPlanta gestorPlanta = new GestorPlanta();
	private GestorRuta gestorRuta = new GestorRuta();
	
	private ArrayList<Planta> listaPlantas= new ArrayList<Planta>();
	private ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
	
	public GrafoPlantasDuracion() { 
		listaPlantas = gestorPlanta.recuperarPlantasTodas();
		
		for(Planta p: listaPlantas) {
			this.addNodo(p);
		}
		
		listaRutas = gestorRuta.recuperarRutas();
		
		for(Ruta r: listaRutas) {
			this.conectar(gestorPlanta.recuperarPlantaId(r.getPlantaOrigen()), gestorPlanta.recuperarPlantaId(r.getPlantaDestino()), r.getDuracionEnHoras());

		}
		
	}
	
	public void aplicarDijkstra(Integer idPlantaOrigen, Integer idPlantaFin) {
		
		Dijkstra algoritmo = new Dijkstra(this);
		
		algoritmo.execute( getNodo(gestorPlanta.recuperarPlantaId(idPlantaOrigen)) );
		
		LinkedList<Vertice> res = algoritmo.getPath(getNodo(gestorPlanta.recuperarPlantaId(idPlantaFin)));
		
		System.out.println("RUTA ES EN DURACION" + res);

	}

	
}