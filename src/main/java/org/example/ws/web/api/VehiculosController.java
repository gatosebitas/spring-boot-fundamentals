package org.example.ws.web.api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.example.ws.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mapa.models.Vehiculo;

@RestController
public class VehiculosController {

    private static BigInteger nextId;
    private static Map<BigInteger, Vehiculo> vehiculoMap;

    private static Vehiculo save(Vehiculo vehiculo) {
        if (vehiculoMap == null) {
            vehiculoMap = new HashMap<BigInteger, Vehiculo>();
            nextId = BigInteger.ONE;
        }
        vehiculo.setId(nextId);
        nextId = nextId.add(BigInteger.ONE);
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
    	Vehiculo v;
    	for(int i=1;i<=100;i++) {
        v = new Vehiculo();       
        v.setLatitud(randomWithRangeLt(1,1000));
        v.setLongitud(randomWithRangeLn(1,1000));
        v.setFecha("03/12/2018");
        save(v);
    	}
       
    }

    @RequestMapping(
            value = "/api/vehiculos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Vehiculo>> getVehiculos() {

        Collection<Vehiculo> vehiculos = vehiculoMap.values();

        return new ResponseEntity<Collection<Vehiculo>>(vehiculos,
                HttpStatus.OK);
    }

}
