package org.example.ws.web.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.example.ws.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mapa.dao.DAOVehiculo;
import com.mapa.models.Vehiculo;
import com.mapa.services.Facade;

@RestController
public class VehiculosController {

    private static Integer nextId;
    private static Map<Integer, Vehiculo> vehiculoMap = new HashMap<Integer, Vehiculo>();
    
    @Autowired
	private static DAOVehiculo daoVehiculo = new DAOVehiculo();

    private static Vehiculo save(Vehiculo vehiculo) {
        if (vehiculoMap == null) {
            vehiculoMap = new HashMap<Integer, Vehiculo>();
        }
        
        vehiculoMap.put(vehiculo.getId(), vehiculo);
        
        return vehiculo;
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
    	    	
    	ArrayList<Vehiculo> list = daoVehiculo.listar();
    	for (Vehiculo v: list) {
    	    save(v);
    	}
       
    }

    @RequestMapping(
            value = "/api/vehiculos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Vehiculo>> getVehiculos() {

        Collection<Vehiculo> vehiculos = vehiculoMap.values();
    	//Collection<Vehiculo> vehiculos = daoVehiculo.listar();
    	
        return new ResponseEntity<Collection<Vehiculo>>(vehiculos,
                HttpStatus.OK);
    }

}
