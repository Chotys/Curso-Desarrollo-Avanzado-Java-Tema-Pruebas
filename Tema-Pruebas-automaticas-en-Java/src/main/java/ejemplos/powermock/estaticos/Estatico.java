package ejemplos.powermock.estaticos;

/**
 * Delegado con m�todos est�ticos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 * 
 */
public class Estatico {
	
	/**
	 * Sumar dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return suma a m�s b
	 */
	public static int sumar(int a, int b) {
		if (a<0) throw new RuntimeException();
		return a+b;
	}
	
	/**
	 * Resta de dos valores.
	 * 
	 * @param a
	 *            a
	 * @param b
	 *            b
	 * @return resta de a menos b
	 */
	public static int restar(int a, int b) {
		if (a<0) throw new RuntimeException();
		return a-b;
	}

}
