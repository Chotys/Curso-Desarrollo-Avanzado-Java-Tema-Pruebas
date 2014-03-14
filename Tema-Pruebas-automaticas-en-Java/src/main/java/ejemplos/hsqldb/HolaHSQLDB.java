package ejemplos.hsqldb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ejemplo b�sico con la base de datos en memoria de HSQLDB (HyperSQL)
 * Ver: <a href=>http://hsqldb.org/">HSQLDB</a>
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 */
public class HolaHSQLDB {

	/**
	 * Ejemplo b�sico de conexi�n y cierre a la base de datos,
	 * equivalente a un HolaMundo inicial.
	 * 
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		 try {
		    Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:memoriadb");
		    System.out.println("Cat�logo actual (deber�a ser PUBLIC): " + connection.getCatalog());
		    DatabaseMetaData dmd = connection.getMetaData();
		    System.out.println("URL de conexi�n: " + dmd.getURL().toString());
		    connection.close(); // cerramos
		 } catch (SQLException e) {
			 System.err.println("Error en conexi�n a la base de datos, revise su CLASSPATH");
			 System.err.println("y a�ada el fichero hsqldb.jar al mismo.");			
		    e.printStackTrace();
		 }
	}
}