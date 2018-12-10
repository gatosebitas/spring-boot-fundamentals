package com.mapa.models;

public class Punto_Interes {
	
	private int id;
    private Double latitud;
    private Double longitud;
    private String title;
    private String subtitle;
    public Punto_Interes() {}
	public Punto_Interes(int id, Double latitud, Double longitud, String title, String subtitle) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.title = title;
		this.subtitle = subtitle;
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
