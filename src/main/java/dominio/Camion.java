package dominio;


import java.time.LocalDate;
import java.util.ArrayList;

public class Camion {
	private Integer id;
	private String patente;
	private String modelo;
	private Double kmRecorridos;
	private Double costoPorKm;
	private Double costoPorHora;
	private LocalDate fechaDeCompra;
	private ArrayList<Envio> envios;
	private Integer idPlanta;
	
	public Camion() {
		super();
	}
	
	public Camion(Integer id) {
		super();
		this.id=id;
	}
	
	public Camion(Integer id, String patente, String modelo, Double kmRecorridos, Double costoPorKm,
			Double costoPorHora, LocalDate fechaDeCompra) {
		
		super();
		this.id = id;
		this.patente = patente;
		this.modelo = modelo;
		this.kmRecorridos = kmRecorridos;
		this.costoPorKm = costoPorKm;
		this.costoPorHora = costoPorHora;
		this.fechaDeCompra = fechaDeCompra;

	}
	
	
	//Devuelve un string del tipo {"HXL-655","Hyundai Santa Fe","2007-2-13","40000","1","10"}
	public String[] listaAtributos(){
		String[] res = new String[] {id.toString(), patente, modelo,fechaDeCompra.toString(),kmRecorridos.toString(), costoPorKm.toString(), costoPorHora.toString()};
		return res;
		
	}

	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(Double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public Double getCostoPorKm() {
		return costoPorKm;
	}
	public void setCostoPorKm(Double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}
	public Double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(Double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	public LocalDate getFechaDeCompra() {
		return fechaDeCompra;
	}
	public void setFechaDeCompra(LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
	public ArrayList<Envio> getEnvios() {
		return envios;
	}
	public void setEnvios(ArrayList<Envio> envios) {
		this.envios = envios;
	}
	public Integer getPlanta() {
		return idPlanta;
	}
	public void setPlanta(int i) {
		this.idPlanta = i;
	}
	
}
