package com.mapa.models;

public class Vehiculo {

	 private int id;
    private Double latitud;
    private Double longitud;
    private String fecha;
    private Double velocidad;
    public Vehiculo() {
    	
    }
	public Vehiculo(int id, Double latitud, Double longitud, String fecha, Double velocidad) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.fecha = fecha;
		this.velocidad = velocidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}
    
    
    
}
