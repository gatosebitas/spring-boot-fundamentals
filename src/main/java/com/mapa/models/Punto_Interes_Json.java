package com.mapa.models;

public class Punto_Interes_Json {
	private String id;
    private String latitud;
    private String longitud;
    private String title;
    private String subtitle;
    
    
    
    
	public Punto_Interes_Json(String id, String latitud, String longitud, String title, String subtitle) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.title = title;
		this.subtitle = subtitle;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
    
    
    

}
