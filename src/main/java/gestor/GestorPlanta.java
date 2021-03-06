package gestor;

import java.util.ArrayList;

import dominio.ItemPedido;
import dominio.Pedido;
import dominio.Planta;
import dominio.Stock;
import enums.EstadoPedido;
import servicios.PlantaServicio;

public class GestorPlanta {
	
	
	private Planta p;
	private PlantaServicio ps = new PlantaServicio();
	private GestorPedido gp = new GestorPedido();
	private GestorStock gs = new GestorStock();
	
	
	public void altaPlanta(String nombre) {
		
		Planta p = new Planta(1,nombre);
		
		
		ps.altaPlanta(p);
		
	}
	
	Planta buscarPlanta(String id) {
		return p;
	}
	
	Double getFlujoMaximo(Planta pA, Planta pB) {

			return 0.0;
	}
	
	ArrayList<Planta> getListaPlantasOrdenadasPorPageRank() {
		
		return new ArrayList<Planta>();
	}
	
	public ArrayList<Planta> recuperarPlantasTodas() {
		return this.ps.recuperarPlantasTodas();
	}
	
	
	public ArrayList<ArrayList<String>> recuperarPlantasConInsumoMenorAlPtoPedido(){
		return ps.recuperarPlantasConInsumoMenorAlPtoPedido();
	}
	
	public ArrayList<Planta> listarPlantasConStockDeItems(ArrayList<ItemPedido> items, Integer nroOrden){
		
		ArrayList<Planta> listaTodasPlantas = this.recuperarPlantasTodas();// recuperar todas las plantas
		ArrayList<Planta> listaPlantasSinStock = new ArrayList<Planta>();
		
		Integer cantItems = items.size();
		for(Planta plantaActual:listaTodasPlantas) {
			Boolean tieneTodosLosItemsConStock = true;
			for(int i=0; i<cantItems && tieneTodosLosItemsConStock;i++) {
				
				Stock stockAux = this.gs.recuperarStockDeUnInsumoEnUnaPlanta(plantaActual.getId(), items.get(i).getIdInsumo());
				
				if(stockAux==null || stockAux.getCantidad()<items.get(i).getCantidad()){
					
					tieneTodosLosItemsConStock = false;			
					listaPlantasSinStock.add(plantaActual);
				}
			}				
		}
		listaTodasPlantas.removeAll(listaPlantasSinStock);
		if(listaTodasPlantas.isEmpty()) gp.modificarEstadoPedido(new Pedido(nroOrden), EstadoPedido.CANCELADO);
		
		
		return listaTodasPlantas;
	}
	
	public Planta recuperarPlantaId(Integer id) {
		return ps.recuperarPlantaId(id);
	}
	

}
