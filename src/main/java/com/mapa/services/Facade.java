package com.mapa.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mapa.models.*;

public class Facade {

	private static final String Vehiculos_NODE = "usuarios2";
	private static final String Puntos_interes_NODE = "Puntos_interes";
	private static final String Coordena_poligono_NODE = "Coord_pol";

	private DatabaseReference databaseReference;


	private List<Vehiculo> list_Vehiculo;
	private Vehiculo vehiculo2;

	private List<Coordenada_Poligono> list_coordenada;
	private Coordenada_Poligono coordenada2;

	private List<Punto_Interes> list_puntos_interes;
	private Punto_Interes puntos_interes2;

	FirebaseApp app;

	public String respuesta="Hiiiii��";

	public Facade() {
		//FileInputStream serviceAccount;

		FirebaseApp firebaseApp = null;

		try {
			FileInputStream serviceAccount = new FileInputStream("C:\\Users\\fernando\\eclipse-workspace\\Probando\\src\\main\\resources\\tracker-taxis.json");
			FirebaseOptions options;


			try {
				options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount))

						.setDatabaseUrl("https://tracker-taxis-2d95e.firebaseio.com")
						.build();
				//FirebaseApp.initializeApp(options);

				List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
				if(firebaseApps!=null && !firebaseApps.isEmpty()){
					for(FirebaseApp app : firebaseApps){
						if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
							firebaseApp = app;
					}
					System.out.println("No Se inicio la aplicacion");
				}
				else {
					System.out.println("Se inicio la aplicacion");
					app=firebaseApp = FirebaseApp.initializeApp(options);   
				}

				//probando esto

				DatabaseReference ref = FirebaseDatabase
						.getInstance()
						.getReference("/usuarios2");

				ref.addValueEventListener(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot dataSnapshot) {
						String res = (String) dataSnapshot.getValue();
						respuesta=respuesta+res+" ";
						System.out.println(res);
					}


					@Override
					public void onCancelled(DatabaseError arg0) {
						// TODO Auto-generated method stub

					}
				});

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public List<Vehiculo> listarVehiculo(String nodo) {
		//FirebaseDatabase.getInstance().setPersistenceEnabled(false);
		list_Vehiculo = new ArrayList<>();
		databaseReference = FirebaseDatabase.getInstance(app).getReference();
		databaseReference.child(Vehiculos_NODE).addValueEventListener(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
						Vehiculo_Json vehiculo= snapshot.getValue(Vehiculo_Json.class);
						BigInteger id=BigInteger.valueOf(Long.parseLong(vehiculo.getId()));
						Double latitud=Double.parseDouble(vehiculo.getLatitud());
						Double longitud= Double.parseDouble(vehiculo.getLongitud());
						String fecha=vehiculo.getFecha();
						Double velocidad= Double.parseDouble(vehiculo.getVelocidad());
						vehiculo2 = new Vehiculo(id,latitud,longitud,fecha,velocidad);
						list_Vehiculo.add(vehiculo2);
					}
				}
			}
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("Hubo un error en la conexion a la base de datos"+ databaseError);
			}
		});
		return list_Vehiculo;
	}
	
	public List<Punto_Interes> listarPuntoInteres(String nodo) {
		//FirebaseDatabase.getInstance().setPersistenceEnabled(false);
		list_puntos_interes = new ArrayList<>();
		databaseReference = FirebaseDatabase.getInstance(app).getReference();
		databaseReference.child(Puntos_interes_NODE).addValueEventListener(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
						Punto_Interes_Json punto= snapshot.getValue(Punto_Interes_Json.class);
						BigInteger id=BigInteger.valueOf(Long.parseLong(punto.getId()));
						Double latitud=Double.parseDouble(punto.getLatitud());
						Double longitud= Double.parseDouble(punto.getLongitud());
						String title=punto.getTitle();
						String subtitle=punto.getSubtitle();
						puntos_interes2 = new Punto_Interes(id,latitud,longitud,title,subtitle);
						list_puntos_interes.add(puntos_interes2);
					}
				}
			}
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("Hubo un error en la conexion a la base de datos"+ databaseError);
			}
		});
		return list_puntos_interes;
	}
	
	
	public List<Coordenada_Poligono> listarCoordenadaPoligono(String nodo) {
		//FirebaseDatabase.getInstance().setPersistenceEnabled(false);
		list_coordenada = new ArrayList<>();
		databaseReference = FirebaseDatabase.getInstance(app).getReference();
		databaseReference.child(Coordena_poligono_NODE).addValueEventListener(new ValueEventListener() {
			public void onDataChange(DataSnapshot dataSnapshot) {
				if (dataSnapshot.exists()) {
					for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
						Coordenada_Poligono_Json punto= snapshot.getValue(Coordenada_Poligono_Json.class);
						BigInteger id=BigInteger.valueOf(Long.parseLong(punto.getId()));
						Double latitud=Double.parseDouble(punto.getLatitud());
						Double longitud= Double.parseDouble(punto.getLongitud());
						
						coordenada2 = new Coordenada_Poligono(id,latitud,longitud);
						list_coordenada.add(coordenada2);
					}
				}
			}
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("Hubo un error en la conexion a la base de datos"+ databaseError);
			}
		});
		return list_coordenada;
	}

}
