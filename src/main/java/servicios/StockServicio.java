package servicios;

import java.util.ArrayList;

import dao.StockDao;
import dao.StockDaoPostgreSQL;
import dominio.Camion;
import dominio.Stock;

public class StockServicio {

	
	private StockDao stockDao = new StockDaoPostgreSQL();
	
	public void altaStock(Stock s) {
		
		this.stockDao.altaStock(s);
	}
	
	public Integer getStockDeUnInsumo(Integer id) {
		return stockDao.getStockDeUnInsumo(id);
		
	}
	
	public ArrayList<Stock> recuperarTodosStockDePlanta(Integer idPlanta){
		return stockDao.recuperarTodosStockDePlanta(idPlanta);
		
	}
	
	public Stock recuperarStockDeUnInsumoEnUnaPlanta(Integer idPlanta, Integer idInsumo) {
		return stockDao.recuperarStockDeUnInsumoEnUnaPlanta(idPlanta, idInsumo);
	}
}
