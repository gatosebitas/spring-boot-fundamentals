package com.mapa.models;

import java.math.BigInteger;

public class Coordenada_Poligono_Json {
	
	private String id;
	 private String latitud;
	 private String longitud;
	 
	 
	 
	public Coordenada_Poligono_Json(String id, String latitud, String longitud) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
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

	 
}
