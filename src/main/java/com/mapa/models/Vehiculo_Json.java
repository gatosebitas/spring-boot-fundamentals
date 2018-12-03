package com.mapa.models;

public class Vehiculo_Json {
	private String id;
    private String latitud;
    private String longitud;
    private String fecha;
    private String velocidad;
    
    
    
	public Vehiculo_Json(String id, String latitud, String longitud, String fecha, String velocidad) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.fecha = fecha;
		this.velocidad = velocidad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

    
    
    
    
	
    
    

}
