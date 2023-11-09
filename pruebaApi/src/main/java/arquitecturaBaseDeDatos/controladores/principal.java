package arquitecturaBaseDeDatos.controladores;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import arquitecturaBaseDeDatos.servicios.implementacionConexion;
import arquitecturaBaseDeDatos.servicios.interfazConexion;

public class principal {

	public static void main(String[] args) {
		 try {
	            URL url = new URL("http://localhost:8080/api/usuario");
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            String [] vectorUsers= {};
	            while ((line = reader.readLine()) != null) {
	            	vectorUsers=line.split("}");
	            }
	            for(int i=0;i<vectorUsers.length;i++) {
	            	System.out.println(vectorUsers[i]);
	            }
	            reader.close();
	            connection.disconnect();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}
