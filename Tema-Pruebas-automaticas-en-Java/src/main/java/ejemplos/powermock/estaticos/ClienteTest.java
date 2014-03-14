package ejemplos.powermock.estaticos;

import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

/**
 * Test de demostraci�n del uso de PowerMock con m�todos est�ticos.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Estatico.class)
public class ClienteTest {

	/**
	 * Test que comprueba invocaci�n a m�todos est�ticos.
	 */
	@Test
	public void test1() {
		 // Clase sobre la que se intercepta...
		mockStatic(Estatico.class);
		// Stubbing del m�todo est�tico sumar:
		// cuando se invoca al m�todo sumar con valores (2,2) retorna 4
		when(Estatico.sumar(2, 2)).thenReturn(4);
		// lo mismo con la resta
		when(Estatico.restar(2, 2)).thenReturn(0);

		Cliente cliente = new Cliente(2, 2);	
		// M�todo que invoca a m�todo est�ticos con stubbing
		int resultadoSuma = cliente.sumar();
		assertThat(resultadoSuma, is(4));
		int resultadoResta = cliente.restar();
		assertThat(resultadoResta, is(0));

		// Verificaci�n de que se ha invocado al m�todo est�tico
		PowerMockito.verifyStatic(); // obligatorio antes de comprobar
		Estatico.sumar(2, 2); // comprobar

		// Verificaci�n de que se ha invocado al m�todo est�tico
		PowerMockito.verifyStatic(); // obligatorio antes de comprobar
		Estatico.restar(2, 2); // comprobar
	}

	/**
	 * Test que comprueba lanzamiento de excepci�n sobre m�todo est�tico.
	 * 
	 */
	@Test(expected=ArithmeticException.class)
	public void test2() {
		 // Clase sobre la que se intercepta...
		mockStatic(Estatico.class);
		// Lanzar excepci�n...
		doThrow(new ArithmeticException()).when(Estatico.class);
		// ... al invocar a restar con estos par�metros.
		Estatico.restar(666, 666);

		// Operaciones sobre el cliente.
		Cliente cliente = new Cliente(0, 0);
		cliente.setA(666);
		cliente.setB(666);
		cliente.restar(); // intentamos restar, DEBE lanzar excepci�n.
	}
}
