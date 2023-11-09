package arquitecturaBaseDeDatos.servicios;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class implementacionConexion implements interfazConexion {

	public Connection conexionBaseDeDatos() {
		//Creamos la conexion
				Connection BaseDatos = null;
				//Cogemos los datos del archivo .propeties
				String [] parametros = pasaParametros("C:\\Users\\Puesto3\\git\\pruebaBaseDeDatos\\src\\modelo\\claves.properties");
				try {
					
				 //Se pasa los datos de conexion
			    BaseDatos = DriverManager.getConnection(parametros[0], parametros[1], parametros[2]);
			    //Comprobamos la conexion
			    boolean esValidad=BaseDatos.isValid(5000);
			    //Si no es validad la conexion lo ponemos a null
			    if(!esValidad)
			    	BaseDatos=null;
			    //Excepciones
				}catch(SQLException e) {
					System.out.println("Se produjo un fallo en la conexion de datos en la implementacion"+e.getMessage());
				}
				//Devuelve la conexion
				return BaseDatos;
	}
	
	private String[] pasaParametros(String ruta) {
		//Creamos el objeto properties
		Properties properties= new Properties();
		//Creamos el vector donde van los datos
		String [] parametros = new String [3];
		try {
			//Indicamos donde esta el fichero
			properties.load(new FileInputStream(new File(ruta)));
			//Cogemos los avlores y lso metemos e el vector 
			parametros[0]=properties.getProperty("jdbc");
			parametros[1]=properties.getProperty("USUARIO");
			parametros[2]=properties.getProperty("CLAVE");
		//Excepciones
		}catch(Exception e) {
			System.out.println("Se produjo un error en PasaParemetros de la implementacion "+e.getMessage());
		}
		return parametros;
	}

	public void cerrarBaseDeDatos(Connection conexion) {
		try {
			//Cerramos la conexion
		conexion.close();
		//Excepciones
		}catch(SQLException e) {
			System.out.println("no se pudo desconectar la  base de datos en la implementacion"+e.getMessage());	
		}
	}

}
