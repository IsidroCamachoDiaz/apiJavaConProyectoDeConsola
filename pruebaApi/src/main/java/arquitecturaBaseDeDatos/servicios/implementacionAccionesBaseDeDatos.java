package arquitecturaBaseDeDatos.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implementacionAccionesBaseDeDatos implements interfazAccionesBaseDeDatos {

	public List<Object> insertarQuery(String query, Connection conexion) {
		//Creamos el stament y el resulset
				Statement st = null;
				ResultSet rs= null;
				//Creamos la lista a null
				List <Object> libros=null;
				try {
					//Se relaciona la base de datos
				    st = conexion.createStatement();
				    //Se mete la query
				    rs = st.executeQuery(query);
				    //Metemoe el resultado en el metodo que devuelve la lista de libros llena
				    libros=pasaDto(rs);
				    //Cerramos los objetos
				    st.close();
				    rs.close();
				    //Excepciones
				}catch(SQLException eq) {
					System.out.println("Se produjo un fallo en la query en la implementacion de accion de base de datos "+eq.getMessage());
				}
				return libros;
	}

	public void insertarDatos(List<Object> libros, Connection conexion) {
		//Ponemos a null el stament
				PreparedStatement st = null;
				//Esta variable sirve por si hay algun problema dice los libros que se han insertado
				int e=0;
				try {
					//Se relaciona la base de datos
				    //Se hace un bucle para insertar todos los libroos
				    for(int i=0;i<libros.size();i++) {
				    	//Se crea la query
				    	String query2="INSERT INTO gbp_almacen.gbp_alm_cat_libros (titulo,autor,isbn,edicion) VALUES (?,?,?,?)";
				    	st = conexion.prepareStatement(query2);
				    	
				         //Se ejecuta la query
				    	st.executeUpdate();
				    	//Se iguala la variable
				          e=i;
				    }
				    //Se cierra la conexion
				    st.close();
				    //Excepciones
				}catch(SQLException ed) {
					System.out.println("no se insertar los datos en la implementcion"+ed.getMessage()+"Se ha insertado hasta "+e);	
				}

	}

	public void ActualizarDatos(Object libro1, Connection conexion) {
		//Se crea el PreparedStanmet a null
				PreparedStatement st = null;
				try {
					//Se crea la query con los interrogantes donde vaya el valor
					String sql = "UPDATE gbp_almacen.gbp_alm_cat_libros SET titulo=?,autor=?,isbn=?,edicion=? WHERE id_libro=?";
				   //Metemos la query
					st = conexion.prepareStatement(sql);
					//Ponemos los valores donde van los interrogantes

				    //Se ejecuta la query
				    st.executeUpdate();
				    //Se cierra la consulta
				    st.close();
				    //Excepciones
				}catch(SQLException ed) {
					System.out.println("no se ha podido insertar los datos en la implementcion"+ed.getMessage());	
				}

	}

	public void BorrarDatos(Object libro1, Connection conexion) {
		//Se pone el PreparedStament a NULL
				PreparedStatement st = null;
				try {
					//Se crea la query con los interrogantes donde vaya el valor
					String sql = "DELETE FROM gbp_almacen.gbp_alm_cat_libros WHERE id_libro=?";
					 //Metemos la query
				    st = conexion.prepareStatement(sql);
				  //Ponemos los valores donde van los interrogantes

				    //eJECUTAMOS LA QUERY
				    st.executeUpdate();
				    //Se cierra la consulta
				    st.close();
				    //Excepciones
				}catch(SQLException ed) {
					System.out.println("no se insertar los datos en la implementcion"+ed.getMessage());	
				}

	}
	//Este metodo sirve paar coger los resultados y merterlos en la lista
		private List<Object> pasaDto(ResultSet rs){
			//Creamos la lista
			List <Object> libros = new ArrayList <Object>();
			try {
				//Creamos el bucle para que vaya cogiendo cada linea y vamos metiendo cada uno en la lista
			 while(rs.next() ) {
				    //Creacion entidad y meter en lista
				    }
			 //Excepciones
			}catch(SQLException sq) {
				System.out.println("Se produjo un error de lectura en la implementacion "+sq.getMessage());
			}
			return libros;
			
		}

}
