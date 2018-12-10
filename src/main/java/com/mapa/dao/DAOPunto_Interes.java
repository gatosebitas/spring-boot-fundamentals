package com.mapa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mapa.models.Punto_Interes;

@Repository
public class DAOPunto_Interes {

	private Conexion conexion;
	
	public void registrar(Punto_Interes punto){
       
		String sql = "INSERT INTO puntos_interes(latitud, longitud, title, subtitle) values(?,?,?,?)";
		try {
			conexion = new Conexion();
	        conexion.establecerConexion();
	        
	        PreparedStatement p_statement =
                    conexion.getConnection().prepareStatement(sql);
	        
	        p_statement.setDouble(1, punto.getLatitud());
	        p_statement.setDouble(2, punto.getLongitud());
	        p_statement.setString(3, punto.getTitle());
	        p_statement.setString(4, punto.getSubtitle());
	        p_statement.executeUpdate();
	        p_statement.close();
		} catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        	if(conexion != null) {
        		conexion.cerrarConexion();
        	}
        }
	}
	
	public ArrayList<Punto_Interes> listar(){
		
		ArrayList<Punto_Interes> list = new ArrayList<Punto_Interes>();
		
		
		String sql = "SELECT id, "
				+ "latitud, "
				+ "longitud, "
				+ "title, "
				+ "subtitle "
				+ "FROM puntos_interes";
		try {
			
			conexion = new Conexion();
	        conexion.establecerConexion();
	        
	        Statement statement = conexion.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

			while(result.next()){
                list.add(
                        new Punto_Interes(
                                result.getInt("id"),
                                result.getDouble("latitud"),
                                result.getDouble("longitud"),
                                result.getString("title"),
                                result.getString("subtitle")
                        )
                );
            }
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        	if(conexion != null) {
        		conexion.cerrarConexion();
        	}
        }
		return list;
				
	}
}