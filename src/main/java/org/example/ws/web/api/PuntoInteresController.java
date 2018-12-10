package org.example.ws.web.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.example.ws.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mapa.dao.DAOPunto_Interes;
import com.mapa.dao.DAOVehiculo;
import com.mapa.models.Punto_Interes;
import com.mapa.models.Vehiculo;

@RestController
public class PuntoInteresController {

    private static BigInteger nextId;
    private static Map<Integer, Punto_Interes> puntoMap = new HashMap<Integer, Punto_Interes>();
    
    @Autowired
	private static DAOPunto_Interes daoPunto_Interes = new DAOPunto_Interes();
    
    private static Punto_Interes save(Punto_Interes punto) {
        if (puntoMap == null) {
            puntoMap = new HashMap<Integer, Punto_Interes>();
        }
        puntoMap.put(punto.getId(), punto);
        
        return punto;
    }
    
    private static double randomWithRangeLt(int min, int max)
    {
       int range = (max - min) + 1;     
       return -(16+((Math.random() * range) + min)/10000);
    }
    private static double randomWithRangeLn(int min, int max)
    {
       int range = (max - min) + 1;     
       return -(74+((Math.random() * range) + min)/10000);
    }

    static {
    	ArrayList<Punto_Interes> list = daoPunto_Interes.listar();
    	for (Punto_Interes p: list) {
    	    save(p);
    	}
       
    }

    @RequestMapping(
            value = "/api/puntos_interes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Punto_Interes>> getPuntos() {

        Collection<Punto_Interes> puntos = puntoMap.values();

        return new ResponseEntity<Collection<Punto_Interes>>(puntos,
                HttpStatus.OK);
    }

}
