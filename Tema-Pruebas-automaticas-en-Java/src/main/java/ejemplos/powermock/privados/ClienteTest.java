package ejemplos.powermock.privados;

import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test de demostraci�n del uso de PowerMock con m�todo privado.
 * 
 * @author <A HREF="mailto:rmartico@ubu.es">Ra�l Marticorena</A>
 * @author <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.0
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Delegado.class)
public class ClienteTest {

	/**
	 * Test que accede al m�todo privado validar de un delegado "real"
	 * utilizando esp�as.
	 */
	@Test
	public void test1() throws Exception {
		// Espiamos al delegado
		Delegado delegado = spy(new Delegado());
		// stubbing de m�todo privado
		// no es necesario puesto que la implementaci�n real nos vale
		doReturn(true).when(delegado, "validar", 1);

		// Operaciones sobre el cliente
		Cliente cliente = new Cliente(1, 0, delegado);
		cliente.sumar();
		// Verificamos que el m�todo privado validar se ha invocado
		verifyPrivate(delegado).invoke("validar", 1);
	}
}
