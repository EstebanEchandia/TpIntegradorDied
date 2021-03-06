package servicios;

import java.util.ArrayList;

import dao.PlantaDao;
import dao.PlantaDaoPostgreSQL;
import dominio.Planta;

public class PlantaServicio {
	
	private PlantaDao pd = new PlantaDaoPostgreSQL();
	
	public Planta altaPlanta(Planta p) {
		return this.pd.altaPlanta(p);
	}
	
	public ArrayList<Planta> recuperarPlantasTodas() {
		return this.pd.recuperarPlantasTodas();
	}
	
	public ArrayList<ArrayList<String>> recuperarPlantasConInsumoMenorAlPtoPedido(){
		return pd.recuperarPlantasConInsumoMenorAlPtoPedido();

	}
	
	public Planta recuperarPlantaId(Integer id) {
		return pd.recuperarPlantaId(id);
	}
	
}
