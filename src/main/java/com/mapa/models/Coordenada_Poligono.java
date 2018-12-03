package com.mapa.models;

import java.math.BigInteger;

public class Coordenada_Poligono {
	private BigInteger id;
	 private Double latitud;
	 private Double longitud;
	public Coordenada_Poligono(BigInteger id, Double latitud, Double longitud) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
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
	 
	 
}
