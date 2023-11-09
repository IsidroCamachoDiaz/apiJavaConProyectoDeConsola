package arquitecturaBaseDeDatos.servicios;

import java.sql.Connection;

public interface interfazConexion {
	/**
	 * Conecta con la base de datos mediantes los parametros de .properties
	 * @return Conexion
	 * */
	public Connection conexionBaseDeDatos();
	/**
	 * Cierra la conexiond De Base de Datos
	 * 
	 * */
	public void cerrarBaseDeDatos(Connection conexion);
}
