package arquitecturaBaseDeDatos.servicios;

import java.sql.Connection;
import java.util.List;

public interface interfazAccionesBaseDeDatos {
	public List <Object> insertarQuery(String query,Connection conexion);
	/**
	 * Inserta la query de base de datos y crea un libro
	 * */
	public void insertarDatos(List <Object> libros ,Connection conexion);
	/**
	 *Inserta la query en la Base de datos para actualizar
	 * */
	public void ActualizarDatos(Object libro1 ,Connection conexion);
	/**
	 * Inserta la query en la Base de datos para borrar un libro
	 * */
	public void BorrarDatos(Object libro1 ,Connection conexion);
}
